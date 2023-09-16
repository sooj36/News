package com.example.news.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

// fragment 전환 + 상태유지 담당
// fragment 최초 생성 시 , 클래스를 생성 후 FragmentManager에 더해주고, 이미 생성된 fragment 보여줌

@Navigator.Name("keep_state_fragment")
class KeepStateFragment(
    private val context: Context,
    private val manager: FragmentManager,
    private val containerId :Int
):FragmentNavigator(context, manager, containerId) {

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        val tag = destination.id.toString()

        val transaction = manager.beginTransaction()

        var initialNavigator = false
        val currentFragment = manager.primaryNavigationFragment

        if (currentFragment != null) {
            transaction.hide(currentFragment)
        } else {
            initialNavigator = true
        }

        var fragment = manager.findFragmentByTag(tag)

        if (fragment == null) { // add로 fragment 최초 생성 !
            val className = destination.className
            fragment = manager.fragmentFactory.instantiate(context.classLoader, className)
            transaction.add(containerId, fragment, tag)
        } else {
            transaction.show(fragment)
        }

        // destination fragment 를 primary 로 설정 !
        transaction.setPrimaryNavigationFragment(fragment)

        // transaction 관련 fragment 상태 변경 최적화
        transaction.setReorderingAllowed(true)
        transaction.commitNow()

        return if (initialNavigator) {
            destination
        } else {
            null
        }
    }
}
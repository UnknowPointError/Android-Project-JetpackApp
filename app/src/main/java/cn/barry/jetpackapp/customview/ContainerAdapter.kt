package cn.barry.jetpackapp.customview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/customview
 * @Time: 2022/5/8 12:24
 * @Author: BarryAllen
 * @Description: ContainerAdapter
 **************************/
class ContainerAdapter(
    val fragmentArray: Array<Fragment>,
    manager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(manager, lifecycle) {
    override fun getItemCount(): Int = fragmentArray.size

    override fun createFragment(position: Int): Fragment = fragmentArray[position]
}
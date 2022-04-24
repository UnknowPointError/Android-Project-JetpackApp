package cn.barry.jetpackapp.material

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.MaterialRvFruititemBinding

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp/material
 * @Time: 2022/4/23 22:40
 * @Author: BarryAllen
 * @Description: RvAdapter
 * @formatter:off
 **************************/
class MaterialRvAdapter(val fruitList: ArrayList<Fruit>) : RecyclerView.Adapter<MaterialRvAdapter.ViewHolder>() {

    inner class ViewHolder(mBinding : MaterialRvFruititemBinding) : RecyclerView.ViewHolder(mBinding.root) {
        val fruitImage = mBinding.materialRvImageView
        val fruitText = mBinding.materialRvTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MaterialRvFruititemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun getItemCount(): Int = fruitList.size

    /* @formatter:on */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruitData = fruitList[position]
        with(holder) {
            fruitText.text = fruitData.fruitName
            fruitImage.setImageResource(fruitData.fruitImageId)
        }
    }
}



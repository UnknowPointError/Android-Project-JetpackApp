package cn.barry.jetpackapp.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.ActivityMaterialBinding

class MaterialActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityMaterialBinding.inflate(layoutInflater) }
    private val fruit =
        mutableListOf(
            Fruit(R.drawable.apple, "Apple"), Fruit(R.drawable.banana, "Banana"),
            Fruit(R.drawable.orange, "Orange"), Fruit(R.drawable.watermelon, "Watermelon"),
            Fruit(R.drawable.pear, "Pear"), Fruit(R.drawable.grape, "Grape"),
            Fruit(R.drawable.pineapple, "Pineapple"), Fruit(R.drawable.strawberry, "Strawberry"),
            Fruit(R.drawable.cherry, "Cherry"), Fruit(R.drawable.mango, "Mango"),
        )
    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        setSupportActionBar(mBinding.materialToolBar)
        repeat(50) { fruitList.add(fruit.random()) }
        mBinding.materialRecyclerView.layoutManager = GridLayoutManager(this, 2)
        mBinding.materialRecyclerView.adapter = MaterialRvAdapter(fruitList)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.material_toolbar, menu)
        return true
    }

}
package app.wakayama.harusame.school5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

val people = arrayOf("ブタ","ゾウ","ネコ","トラ")
val food = arrayOf("カレー","みそしる","チャーハン","エビチリ","オムライス","マーボー茄子","ラーメン","餃子")

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView1.setImageResource(R.drawable.buta)
        imageView2.setImageResource(R.drawable.zou)
        imageView3.setImageResource(R.drawable.neko)
        imageView4.setImageResource(R.drawable.tora)
        button.setOnClickListener {
            servefood()
        }

    }
    fun servefood(){
        //init
        verbTextView.textSize = 24F
        verbTextView.setTextColor(Color.parseColor("#ffffff"))

        val randomPeopleIndex = kotlin.random.Random.nextInt(4)
        val randomFoodIndex = kotlin.random.Random.nextInt(food.size.toInt())
        val randomNumber = kotlin.random.Random.nextInt(100)
        var isServed = false

        val name = people[randomPeopleIndex]
        val food = food[randomFoodIndex]
        val number = Array(100){it}

        nameTextView.text = name+"に"
        foodTextView.text = food+"を"

        if (randomNumber < 50){
            isServed = true
        }

        when(isServed){
            true -> {
                verbTextView.text = "よそえました！"
            }
            false -> {
                verbTextView.textSize = 40F
                verbTextView.setTextColor(Color.parseColor("#ff0000"))
                verbTextView.text = "よそえませんでした！"
            }
        }
        Log.d("debug",name.toString())
    }
}
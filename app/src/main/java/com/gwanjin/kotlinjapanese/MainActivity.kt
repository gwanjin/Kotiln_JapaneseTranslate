package com.gwanjin.kotlinjapanese

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.gwanjin.kotlinjapanese.client.GooLabClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.testTextView)

        GooLabClient.getHiragana().getConvertedSentence(sentence = "今日は散歩しましょう！")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    item -> textView.setText(item.converted)
                }
                ,{ e -> Log.d("AAA", e.toString())
                }
            )
    }
}
package com.hyun.words

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hyun.words.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("삶이 있는 한 희망은 있다  -키케로")
        sentenceList.add("산다는것 그것은 치열한 전투이다.  -로망로랑")
        sentenceList.add("하루에 3시간을 걸으면 7년 후에 지구를 한바퀴 돌 수 있다. -사무엘존슨")
        sentenceList.add("언제나 현재에 집중할수 있다면 행복할것이다. -파울로 코엘료")
        sentenceList.add("진정으로 웃으려면 고통을 참아야하며 , 나아가 고통을 즐길 줄 알아야 해 -찰리 채플린")
        sentenceList.add("직업에서 행복을 찾아라. 아니면 행복이 무엇인지 절대 모를 것이다 -엘버트 허버드")
        sentenceList.add("신은 용기있는자를 결코 버리지 않는다 -켄러")
        sentenceList.add("행복의 문이 하나 닫히면 다른 문이 열린다 그러나 우리는 종종 닫힌 문을 멍하니 바라보다가")
        sentenceList.add("우리를 향해 열린 문을 보지 못하게 된다  – 헬렌켈러")
        sentenceList.add("피할수 없으면 즐겨라 – 로버트 엘리엇")
        sentenceList.add("단순하게 살아라. 현대인은 쓸데없는 절차와 일 때문에 얼마나 복잡한 삶을 살아가는가?-이드리스 샤흐")
        sentenceList.add("먼저 자신을 비웃어라. 다른 사람이 당신을 비웃기 전에  – 엘사 맥스웰")
        sentenceList.add("먼저핀꽃은 먼저진다  남보다 먼저 공을 세우려고 조급히 서둘것이 아니다 – 채근담")
        sentenceList.add("행복한 삶을 살기위해 필요한 것은 거의 없다. -마르쿠스 아우렐리우스 안토니우스")
        sentenceList.add("절대 어제를 후회하지 마라 . 인생은 오늘의 나 안에 있고 내일은 스스로 만드는 것이다 L.론허바드")
        sentenceList.add("어리석은 자는 멀리서 행복을 찾고, 현명한 자는 자신의 발치에서 행복을 키워간다  -제임스 오펜하임")
        sentenceList.add("너무 소심하고 까다롭게 자신의 행동을 고민하지 말라 . 모든 인생은 실험이다 . 더많이 실험할수록 더나아진다  – 랄프 왈도 에머슨")
        sentenceList.add("한번의 실패와 영원한 실패를 혼동하지 마라  -F.스콧 핏제랄드")
        sentenceList.add("내일은 내일의 태양이 뜬다")
        sentenceList.add("피할수 없으면 즐겨라 -로버트 엘리엇")

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.showSentBtn.setOnClickListener {
            val intent = Intent(this, SentenceMainActivity::class.java)
            startActivity(intent)
        }
        binding.wordTextArea.setText(sentenceList.random())
        binding.refreshBtn.setOnClickListener {
            binding.wordTextArea.setText(sentenceList.random())
        }

    }
}
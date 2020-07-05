package kr.co.namu.testyourluck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_lotto.*

class LottoActivity : AppCompatActivity() {

//    당첨번호 6개 텍스트뷰를 담고 있는 목록
    val lottoNumTxtList = ArrayList<TextView>()

//    당첨 번호 6개 (Int)를 담고 있는 목록
    val winNumList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotto)

//        당첨번호 텍스트뷰 6개를 목록에 추가
        lottoNumTxtList.add(lottoNumTxt01)
        lottoNumTxtList.add(lottoNumTxt02)
        lottoNumTxtList.add(lottoNumTxt03)
        lottoNumTxtList.add(lottoNumTxt04)
        lottoNumTxtList.add(lottoNumTxt05)
        lottoNumTxtList.add(lottoNumTxt06)

//        한장 구매하기 버튼 눌리면
        buyOneLottoBtn.setOnClickListener {
//            랜덤으로 1~45 숫자를 뽑아서 => 6개 텍스트뷰에 반영

//            이미 뽑아둔 번호가 있다면 전부 삭제
            winNumList.clear()

//            6개의 텍스트뷰를 txt에 담으면서 반복
            for (txt in lottoNumTxtList) {

//                중복이 아닐때 까지 계속 다시 뽑자
                while (true) {

//                    1~45의 정수를 랜덤으로 뽑자.
                    val randomNum = (Math.random() * 45 + 1).toInt()

//                    중복 검사를 실행해서
                    var duplicatedCheckResult = true // 중복검사 통과로 전제

//                    당첨 번호를 (저장해둔 배열을) 돌아보면서 같은걸 발견하면 중복검사 통과 실패

                    for (num in winNumList) {
                        if (num == randomNum) {
                            duplicatedCheckResult = false
                        }
                    }

//                    중복검사를 통과했다면
                    if (duplicatedCheckResult) {

//                        뽑은 랜덤 번호를 당첨번호로 인정. (등록)
                        winNumList.add(randomNum)

                        break
                    }
                }

            }

//            실제 뽑힌 번호들 확인
            for (num in winNumList) {
                Log.d("당첨번호", num.toString())
            }

        }

    }
}
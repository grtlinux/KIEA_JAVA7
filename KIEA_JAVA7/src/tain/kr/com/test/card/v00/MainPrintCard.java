/**
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc. all rights reserved.
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3, 29 June 2007 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * -----------------------------------------------------------------
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc.
 *
 */
package tain.kr.com.test.card.v00;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainPrintCard.java
 *   -. Package    : tain.kr.com.test.card.v00
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 6. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainPrintCard {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainPrintCard.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainPrintCard() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static List<Bean> lstBean = null;
	
	private static void setListBean() throws Exception {
		
		lstBean = new ArrayList<Bean>();
		
		lstBean.add(new Bean("DAY-001", "Look who's here!"               , "이게 누구야!"));
		lstBean.add(new Bean("DAY-002", "Don't mention it."              , "별말을 다해."));
		lstBean.add(new Bean("DAY-003", "What's the weather like?"       , "날씨가 어때?"));
		lstBean.add(new Bean("DAY-004", "I feel like going out."         , "놀러 가고 싶어."));
		lstBean.add(new Bean("DAY-005", "Care for some coffee?"          , "커피 한잔 할래?"));
		lstBean.add(new Bean("DAY-006", "Look on the bright side."       , "긍정적으로 생각해."));
		lstBean.add(new Bean("DAY-007", "What do you mean?"              , "무슨 뜻이죠?"));
		lstBean.add(new Bean("DAY-008", "Can you give me a hand?"        , "좀 도와줄래?"));
		lstBean.add(new Bean("DAY-009", "Want to come along?"            , "같이 갈래?"));
		lstBean.add(new Bean("DAY-010", "He's getting out of hand."      , "감당이 안 돼."));

		lstBean.add(new Bean("DAY-011", "You've crossed the line."       , "너 너무 심했어.")); // 인간관계에서 넘지 말아야 할 한계선을 넘었다.
		lstBean.add(new Bean("DAY-012", "Are you sure?"                  , "정말이야?"));
		lstBean.add(new Bean("DAY-013", "Don't tell me what to do."      , "잔소리 그만해."));
		lstBean.add(new Bean("DAY-014", "I called in sick."              , "나 병가 냈어."));
		lstBean.add(new Bean("DAY-015", "What's up with your hair?"      , "머리는 왜 그래?"));
		lstBean.add(new Bean("DAY-016", "Sounds good."                   , "좋은 생각이야."));
		lstBean.add(new Bean("DAY-017", "This is ridiculous."            , "말도 안 돼."));
		lstBean.add(new Bean("DAY-018", "I'm booked solid."              , "일정이 꽉 찼어."));
		lstBean.add(new Bean("DAY-019", "Time to call it a day."         , "끝낼 시간이야."));
		lstBean.add(new Bean("DAY-020", "I should pay more attention."   , "좀 더 신경 쓸게."));
		
		lstBean.add(new Bean("DAY-021", "Not to worry."                  , "걱정 마."));
		lstBean.add(new Bean("DAY-022", "Let's go for a drive."          , "드라이브 가자."));
		lstBean.add(new Bean("DAY-023", "Just throw away."               , "갖다 버려."));
		lstBean.add(new Bean("DAY-024", "Here we go again."              , "또 시작이야."));
		lstBean.add(new Bean("DAY-025", "Let it go."                     , "신경 꺼."));
		lstBean.add(new Bean("DAY-026", "Now you're talking."            , "바로 그거야."));
		lstBean.add(new Bean("DAY-027", "You're all dressed up."         , "쫙 빼입었네."));
		lstBean.add(new Bean("DAY-028", "Suit yourself!"                 , "맘대로 해!"));
		lstBean.add(new Bean("DAY-029", "Let's get wasted."              , "실컷 마시자."));
		lstBean.add(new Bean("DAY-030", "It's no big deal."              , "별일 아니야."));
		
		lstBean.add(new Bean("DAY-031", "What's wrong with it?"          , "뭐 어때서요?"));
		lstBean.add(new Bean("DAY-032", "I stayed up all night."         , "밤을 고박 새웠어."));
		lstBean.add(new Bean("DAY-033", "Watch your language."           , "말 조심해."));
		lstBean.add(new Bean("DAY-034", "Don't even think about it."     , "꿈도 꾸지 마."));
		lstBean.add(new Bean("DAY-035", "My back is killing me."         , "허리 아파 죽겠어."));
		lstBean.add(new Bean("DAY-036", "I'll see what I can do."        , "제가 알아볼께요."));
		lstBean.add(new Bean("DAY-037", "What took you so long?"         , "왜 이렇게 늦었어?"));
		lstBean.add(new Bean("DAY-038", "Anything good happen?"          , "무슨 좋은 일 있어?"));
		lstBean.add(new Bean("DAY-039", "It's coming up."                , "얼마 안 남았어."));
		lstBean.add(new Bean("DAY-040", "Let me out over there."         , "저기서 내려 줘."));
		
		lstBean.add(new Bean("DAY-041", "She was upset."                 , "그녀가 화났어."));
		lstBean.add(new Bean("DAY-042", "You're all talk."               , "늘 말뿐이야."));
		lstBean.add(new Bean("DAY-043", "I go along with that."          , "동의해요."));
		lstBean.add(new Bean("DAY-044", "I'm sick of this."              , "완전 질렸어."));
		lstBean.add(new Bean("DAY-045", "What brings you here?"          , "여긴 어쩐 일이야?"));
		lstBean.add(new Bean("DAY-046", "How did it go?"                 , "어떻게 됐어?"));
		lstBean.add(new Bean("DAY-047", "Math's not my thing."           , "수학은 싫어."));
		lstBean.add(new Bean("DAY-048", "I can't take it anymore."       , "더 이상 못 참아."));
		lstBean.add(new Bean("DAY-049", "I'm freezing to death."         , "추워 죽겠어."));
		lstBean.add(new Bean("DAY-050", "Hold on, please."               , "잠시만요."));
		
		lstBean.add(new Bean("DAY-051", "Act your age!"                  , "나잇값 좀 해!"));
		lstBean.add(new Bean("DAY-052", "Knock it off!"                  , "그만 좀 해!"));
		lstBean.add(new Bean("DAY-053", "I don't buy it."                , "믿을 수 없어."));
		lstBean.add(new Bean("DAY-054", "I'm not picky about food."      , "난 뭐든 잘 먹어."));
		lstBean.add(new Bean("DAY-055", "He has gone for the day."       , "그는 퇴근했어요."));
		lstBean.add(new Bean("DAY-056", "Make it on time."               , "제시간에 와."));
		lstBean.add(new Bean("DAY-057", "You go by the book."            , "원칙대로 하네."));
		lstBean.add(new Bean("DAY-058", "What's bothering you?"          , "무슨 고민 있어?"));
		lstBean.add(new Bean("DAY-059", "I think I'll pass."             , "사양할께요."));
		lstBean.add(new Bean("DAY-060", "I'm between jobs."              , "구직 중이야."));
		
		lstBean.add(new Bean("DAY-061", "You're on the right track."     , "넌 잘하고 있어."));
		lstBean.add(new Bean("DAY-062", "It tastes funny."               , "맛이 이상해."));
		lstBean.add(new Bean("DAY-063", "Save my seat."                  , "자리 잡아 놔."));
		lstBean.add(new Bean("DAY-064", "It's worth visiting."           , "가 볼 만해."));
		lstBean.add(new Bean("DAY-065", "The game ended in a tie."       , "무승부로 끝났어."));
		lstBean.add(new Bean("DAY-066", "Hang in there."                 , "조금만 참아."));
		lstBean.add(new Bean("DAY-067", "I ran into her."                , "걔를 우연히 만났어."));
		lstBean.add(new Bean("DAY-068", "Sorry to hear that."            , "안됐구나."));
		lstBean.add(new Bean("DAY-069", "You have a minute?"             , "시간 좀 있어?"));
		lstBean.add(new Bean("DAY-070", "Let's split the bill."          , "나눠서 내자."));
		
		lstBean.add(new Bean("DAY-071", "I'm not much of a talker."      , "말주변이 없어."));
		lstBean.add(new Bean("DAY-072", "You don't wanna do that."       , "안 하는 게 좋아."));
		lstBean.add(new Bean("DAY-073", "He blacked out."                , "개 필름이 끊겼어."));
		lstBean.add(new Bean("DAY-074", "Let's make a toast."            , "건배하자."));
		lstBean.add(new Bean("DAY-075", "Hope it works out."             , "잘 되길 바라."));
		lstBean.add(new Bean("DAY-076", "Have you made a profit?"        , "수익 좀 냈어?"));
		lstBean.add(new Bean("DAY-077", "She was taken to the ER."       , "응급실에 실려 갔어."));
		lstBean.add(new Bean("DAY-078", "Please spread the word."        , "입소문 좀 내줘."));
		lstBean.add(new Bean("DAY-079", "It's too much for me."          , "너무 어려워."));
		lstBean.add(new Bean("DAY-080", "They're made for each other."   , "천생연분이야."));
		
		lstBean.add(new Bean("DAY-081", "You didn't come out great."     , "사진 잘 안 나왔네."));
		lstBean.add(new Bean("DAY-082", "Let me sleep on it."            , "다시 생각해 볼게."));
		lstBean.add(new Bean("DAY-083", "Just get to the point."         , "본론만 얘기해."));
		lstBean.add(new Bean("DAY-084", "It's pouring."                  , "비가 억수같이 와."));
		lstBean.add(new Bean("DAY-085", "Let's take a walk."             , "산책 좀 하자."));
		lstBean.add(new Bean("DAY-086", "Thanks for the tip."            , "알려 줘서 고마워."));
		lstBean.add(new Bean("DAY-087", "Keep your voice down."          , "목소리 낮춰."));
		lstBean.add(new Bean("DAY-088", "I got a lecture."               , "나 야단 맞았어."));
		lstBean.add(new Bean("DAY-089", "Fill her up, please."           , "가득 주세요."));
		lstBean.add(new Bean("DAY-090", "Put it on my account."          , "외상으로 할게요."));
		
		lstBean.add(new Bean("DAY-091", "Give me a wake-up call."        , "모닝콜 해 주세요."));
		lstBean.add(new Bean("DAY-092", "I have a bad cough."            , "저 기침이 심해요."));
		lstBean.add(new Bean("DAY-093", "Will that be all?"              , "그게 전부이신가요?"));
		lstBean.add(new Bean("DAY-094", "What do you say?"               , "네 생각은 어때?"));
		lstBean.add(new Bean("DAY-095", "Can I get a refund?"            , "환불 되나요?"));
		lstBean.add(new Bean("DAY-096", "Don't ask for trouble."         , "괜한 짓 하지 마."));
		lstBean.add(new Bean("DAY-097", "I'm sorry for your loss."       , "조의를 표합니다."));
		lstBean.add(new Bean("DAY-098", "Let's face it."                 , "현실을 직시해."));
		lstBean.add(new Bean("DAY-099", "I missed the boat."             , "기회를 놓쳤어."));
		lstBean.add(new Bean("DAY-100", "Don't be a chicken!"            , "겁먹지 마!"));
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new MainPrintCard();

		if (!flag) {
			System.out.println();
			System.out.println("♡♤♧◇ ♠♣♥♦");
		}
		
		if (!flag) {
			System.out.println();
			setListBean();
			
			for (Bean bean : lstBean) {
				String code = bean.getCode();
				String strEng = bean.getStrEng();
				String strHan = bean.getStrHan();
				
				System.out.printf("[%-7s] %-25s", code, strHan);
				try { Thread.sleep(2 * 1000); } catch (InterruptedException e) {}

				System.out.printf("\t* %-40s\n", strEng);
				try { Thread.sleep(1 * 1000); } catch (InterruptedException e) {}
			}
		}
		
		if (flag) {
			System.out.println();
			setListBean();
			
			Bean[] arrBean = lstBean.toArray(new Bean[lstBean.size()]);
			
			for (int i=80; i < arrBean.length; i++) {
				String code = arrBean[i].getCode();
				String strEng = arrBean[i].getStrEng();
				String strHan = arrBean[i].getStrHan();
				
				System.out.printf("[%-7s] %-25s", code, strHan);
				try { Thread.sleep(2 * 1000); } catch (InterruptedException e) {}

				System.out.printf("\t* %-40s\n\n", strEng);
				try { Thread.sleep(1 * 1000); } catch (InterruptedException e) {}
			}
		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag)
			test01(args);
	}
}

class Bean {
	
	private String code;
	private String strEng;
	private String strHan;
	
	public Bean(String code, String strEng, String strHan) {
		this.code = code;
		this.strEng = strEng;
		this.strHan = strHan;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getStrEng() {
		return this.strEng;
	}
	
	public String getStrHan() {
		return this.strHan;
	}
}



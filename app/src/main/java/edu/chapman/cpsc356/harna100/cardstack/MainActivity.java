package edu.chapman.cpsc356.harna100.cardstack;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";
	private FrameLayout fl_cards;
	private Stack<CardModel> cardStack;
	private CardView cardView;
	private int count;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fl_cards = (FrameLayout) findViewById(R.id.fl_cards);
		cardView = new CardView(this, null, new CardModel(Suit.Club, "4"));
		fl_cards.addView(cardView);
		count = 1;
		fillStack();
		cardView.changeCardModel(cardStack.pop());
	}

	public void changeCards(View view) {
		Log.d(TAG, "changeCards: " + count++);
		if(!cardStack.isEmpty()){
			cardView.changeCardModel(cardStack.pop());
		}
		else{
			finish();
		}

	}

	private void fillStack(){
		List<CardModel> cards = new ArrayList<CardModel>();
		int count = 0;
		for (Suit suit : Suit.values()) {
			for (int i = 1; i < 14; ++i) {
				String toUse;
				switch (i) {
					case 1:
						toUse = "A";
						break;
					case 11:
						toUse = "J";
						break;
					case 12:
						toUse = "Q";
						break;
					case 13:
						toUse = "K";
						break;
					default:
						toUse = Integer.toString(i);
						break;
				}
				cards.add(count++, new CardModel(suit, toUse));
			}
		}
		Collections.shuffle(cards);
		cardStack = new Stack<CardModel>();
		for (CardModel card : cards) {
			cardStack.push(card);
		}
	}
}

package edu.chapman.cpsc356.harna100.cardstack;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Paul on 9/29/2017.
 */

public class CardView extends FrameLayout {
	private CardModel cardModel;

	private TextView tv_top;
	private TextView tv_bot;

	private ImageView iv_suit_top;
	private ImageView iv_suit_mid;
	private ImageView iv_suit_bot;

	public CardView(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		setViews();
		cardModel = new CardModel(Suit.Heart, "A");
	}

	public CardView(Context context, AttributeSet attrs, CardModel cardModel){
		super(context, attrs);
		this.cardModel = cardModel;
		LayoutInflater.from(context).inflate(R.layout.fl_card, this, true);

		setViews();
		setCard();
	}

	private void setViews(){
		this.tv_top = (TextView) findViewById(R.id.tv_top_numb);
		this.tv_bot = (TextView) findViewById(R.id.tv_bot_numb);

		this.iv_suit_top = (ImageView) findViewById(R.id.iv_top_suit);
		this.iv_suit_mid = (ImageView) findViewById(R.id.iv_mid_Suit);
		this.iv_suit_bot = (ImageView) findViewById(R.id.iv_bot_suit);

	}

	private void setCard(){
		setSuits();
		setValue();
		setTextColor();
	}

	private void setSuits(){
		int toUse = R.drawable.ic_heart;

		switch(cardModel.getSuit()){
			case Heart:
				toUse = R.drawable.ic_heart;
				break;
			case Diamond:
				toUse = R.drawable.ic_diamond;
				break;
			case Club:
				toUse = R.drawable.ic_club;
				break;
			case Spade:
				toUse = R.drawable.ic_spade;
				break;
		}

		iv_suit_top.setImageResource(toUse);
		iv_suit_mid.setImageResource(toUse);
		iv_suit_bot.setImageResource(toUse);
	}

	private void setValue(){
		tv_top.setText(cardModel.getValue());
		tv_bot.setText(cardModel.getValue());
	}

	private void setTextColor(){
		int toUse = Color.RED;

		switch(cardModel.getSuit()){
			case Heart:
			case Diamond:
				toUse = Color.RED;
				break;
			case Club:
			case Spade:
				toUse = Color.BLACK;
				break;
		}

		tv_top.setTextColor(toUse);
		tv_bot.setTextColor(toUse);
	}

	private void fadeOut(){
//		this.animate().alpha(0f).setDuration(250).start();
		tv_bot.animate().alpha(0f).setDuration(250).start();
		tv_top.animate().alpha(0f).setDuration(250).start();

		iv_suit_top.animate().alpha(0f).setDuration(250).start();
		iv_suit_mid.animate().alpha(0f).setDuration(250).start();
		iv_suit_bot.animate().alpha(0f).setDuration(250).start();
	}

	private void fadeIn(){
//		this.animate().alpha(1f).setDuration(250).start();
		tv_bot.animate().alpha(1f).setDuration(250).start();
		tv_top.animate().alpha(1f).setDuration(250).start();

		iv_suit_top.animate().alpha(1f).setDuration(250).start();
		iv_suit_mid.animate().alpha(1f).setDuration(250).start();
		iv_suit_bot.animate().alpha(1f).setDuration(250).start();
	}


	public void changeCardModel(CardModel newModel){
		this.cardModel = newModel;
		fadeOut();
		this.postDelayed(new Runnable() {
			@Override
			public void run() {
				setCard();
			}
		}, 250);
		this.postDelayed(new Runnable() {
			@Override
			public void run() {
				fadeIn();
			}
		}, 250);
	}

}

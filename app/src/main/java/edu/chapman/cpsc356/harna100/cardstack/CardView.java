package edu.chapman.cpsc356.harna100.cardstack;

import android.content.Context;
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

	public CardView(Context context, AttributeSet attrs, CardModel cardModel){
		super(context, attrs);
		this.cardModel = cardModel;
		LayoutInflater.from(context).inflate(R.layout.fl_card, this, true);

		this.tv_top = (TextView) findViewById(R.id.tv_top_numb);
		this.tv_bot = (TextView) findViewById(R.id.tv_bot_numb);

		this.iv_suit_top = (ImageView) findViewById(R.id.iv_top_suit);
		this.iv_suit_mid = (ImageView) findViewById(R.id.iv_mid_Suit);
		this.iv_suit_bot = (ImageView) findViewById(R.id.iv_bot_suit);

	}
}

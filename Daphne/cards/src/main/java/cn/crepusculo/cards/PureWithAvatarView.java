package cn.crepusculo.cards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import cn.crepusculo.model.PureCardModelWithAvatar;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * <h1>modify class name here</h1>
 * cn.crepusculo.cards
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/12
 */

public class PureWithAvatarView extends BaseCardView implements BaseCardView.bindData<PureCardModelWithAvatar> {
    private CircleImageView imageView;
    private TextView mName;
    private TextView mInfo;
    private TextView mContent;

    public PureWithAvatarView(Context context) {super(context);}
    public PureWithAvatarView(Context context, AttributeSet attrs) {super(context, attrs);}
    public PureWithAvatarView(Context context, AttributeSet attrs, int defStyle) {super(context, attrs, defStyle);}

    @Override
    protected void initView() {
        imageView = (CircleImageView)findViewById(R.id.avatar);
        mName =(TextView)findViewById(R.id.name);
        mInfo=(TextView)findViewById(R.id.info);
        mContent =(TextView)findViewById(R.id.content);
    }

    @Override
    protected int setLayout() {
        return R.layout.item_card_pure_with_avatar;
    }


    @Override
    public void bind(PureCardModelWithAvatar data) {
        imageView.setImageResource(data.getPlaceHolderId());
        mName.setText(data.getAuthor());
        mInfo.setText(data.getId());
        mContent.setText(data.getContent());

    }
}

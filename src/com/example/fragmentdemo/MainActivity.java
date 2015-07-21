package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;

/**
 * ���ت��DActivity�A�Ҧ���Fragment���O�J�b�o�̡C
 * 
 * @author guolin
 */
public class MainActivity extends Activity implements OnClickListener {

	/**
	 * �Ω�i�ܮ�����Fragment
	 */
	private MessageFragment messageFragment;

	/**
	 * �Ω�i���pô�H��Fragment
	 */
	private ContactsFragment contactsFragment;

	/**
	 * �Ω�i�ܰʺA��Fragment
	 */
	private NewsFragment newsFragment;

	/**
	 * �Ω�i�ܳ]�m��Fragment
	 */
	private SettingFragment settingFragment;

	/**
	 * �����ɭ��G��
	 */
	private View messageLayout;

	/**
	 * �pô�H�ɭ��G��
	 */
	private View contactsLayout;

	/**
	 * �ʺA�ɭ��G��
	 */
	private View newsLayout;

	/**
	 * �]�m�ɭ��G��
	 */
	private View settingLayout;

	/**
	 * �bTab�G���W��ܮ����ϼЪ�����
	 */
	private ImageView messageImage;

	/**
	 * �bTab�G���W����pô�H�ϼЪ�����
	 */
	private ImageView contactsImage;

	/**
	 * �bTab�G���W��ܰʺA�ϼЪ�����
	 */
	private ImageView newsImage;

	/**
	 * �bTab�G���W��ܳ]�m�ϼЪ�����
	 */
	private ImageView settingImage;

	/**
	 * �bTab�G���W��ܮ������D������
	 */
	private TextView messageText;

	/**
	 * �bTab�G���W����pô�H���D������
	 */
	private TextView contactsText;

	/**
	 * �bTab�G���W��ܰʺA���D������
	 */
	private TextView newsText;

	/**
	 * �bTab�G���W��ܳ]�m���D������
	 */
	private TextView settingText;

	/**
	 * �Ω��Fragment�i��޲z
	 */
	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// ��l�ƧG������
		initViews();
		fragmentManager = getFragmentManager();
		// �Ĥ@���Ұʮɿ襤��0��tab
		setTabSelection(0);
	}

	/**
	 * �b�o�������C�ӻݭn�Ψ쪺���󪺹�ҡA�õ����̳]�m�n���n���I���ƥ�C
	 */
	private void initViews() {
		messageLayout = findViewById(R.id.message_layout);
		contactsLayout = findViewById(R.id.contacts_layout);
		newsLayout = findViewById(R.id.news_layout);
		settingLayout = findViewById(R.id.setting_layout);
		messageImage = (ImageView) findViewById(R.id.message_image);
		contactsImage = (ImageView) findViewById(R.id.contacts_image);
		newsImage = (ImageView) findViewById(R.id.news_image);
		settingImage = (ImageView) findViewById(R.id.setting_image);
		messageText = (TextView) findViewById(R.id.message_text);
		contactsText = (TextView) findViewById(R.id.contacts_text);
		newsText = (TextView) findViewById(R.id.news_text);
		settingText = (TextView) findViewById(R.id.setting_text);
		messageLayout.setOnClickListener(this);
		contactsLayout.setOnClickListener(this);
		newsLayout.setOnClickListener(this);
		settingLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.message_layout:
			// ���I���F����tab�ɡA�襤��1��tab
			setTabSelection(0);
			break;
		case R.id.contacts_layout:
			// ���I���F�pô�Htab�ɡA�襤��2��tab
			setTabSelection(1);
			break;
		case R.id.news_layout:
			// ���I���F�ʺAtab�ɡA�襤��3��tab
			setTabSelection(2);
			break;
		case R.id.setting_layout:
			// ���I���F�]�mtab�ɡA�襤��4��tab
			setTabSelection(3);
			break;
		default:
			break;
		}
	}

	/**
	 * �ھڶǤJ��index�Ѽƨӳ]�m�襤��tab���C
	 * 
	 * @param index
	 *            �C��tab���������U�СC0��ܮ����A1����pô�H�A2��ܰʺA�A3��ܳ]�m�C
	 */
	private void setTabSelection(int index) {
		// �C���襤���e���M�����W�����襤���A
		clearSelection();
		// �}�Ҥ@��Fragment�ư�
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// �����ñ��Ҧ���Fragment�A�H����h��Fragment��ܦb�ɭ��W�����p
		hideFragments(transaction);
		switch (index) {
		case 0:
			// ���I���F����tab�ɡA���ܱ��󪺹Ϥ��M��r�C��
			messageImage.setImageResource(R.drawable.message_selected);
			messageText.setTextColor(Color.WHITE);
			if (messageFragment == null) {
				// �p�GMessageFragment���šA�h�Ыؤ@�ӨòK�[��ɭ��W
				messageFragment = new MessageFragment();
				transaction.add(R.id.content, messageFragment);
			} else {
				// �p�GMessageFragment�����šA�h�����N����ܥX��
				transaction.show(messageFragment);
			}
			break;
		case 1:
			// ���I���F�pô�Htab�ɡA���ܱ��󪺹Ϥ��M��r�C��
			contactsImage.setImageResource(R.drawable.contacts_selected);
			contactsText.setTextColor(Color.WHITE);
			if (contactsFragment == null) {
				// �p�GContactsFragment���šA�h�Ыؤ@�ӨòK�[��ɭ��W
				contactsFragment = new ContactsFragment();
				transaction.add(R.id.content, contactsFragment);
			} else {
				// �p�GContactsFragment�����šA�h�����N����ܥX��
				transaction.show(contactsFragment);
			}
			break;
		case 2:
			// ���I���F�ʺAtab�ɡA���ܱ��󪺹Ϥ��M��r�C��
			newsImage.setImageResource(R.drawable.news_selected);
			newsText.setTextColor(Color.WHITE);
			if (newsFragment == null) {
				// �p�GNewsFragment���šA�h�Ыؤ@�ӨòK�[��ɭ��W
				newsFragment = new NewsFragment();
				transaction.add(R.id.content, newsFragment);
			} else {
				// �p�GNewsFragment�����šA�h�����N����ܥX��
				transaction.show(newsFragment);
			}
			break;
		case 3:
		default:
			// ���I���F�]�mtab�ɡA���ܱ��󪺹Ϥ��M��r�C��
			settingImage.setImageResource(R.drawable.setting_selected);
			settingText.setTextColor(Color.WHITE);
			if (settingFragment == null) {
				// �p�GSettingFragment���šA�h�Ыؤ@�ӨòK�[��ɭ��W
				settingFragment = new SettingFragment();
				transaction.add(R.id.content, settingFragment);
			} else {
				// �p�GSettingFragment�����šA�h�����N����ܥX��
				transaction.show(settingFragment);
			}
			break;
		}
		transaction.commit();
	}

	/**
	 * �M�����Ҧ����襤���A�C
	 */
	private void clearSelection() {
		messageImage.setImageResource(R.drawable.message_unselected);
		messageText.setTextColor(Color.parseColor("#82858b"));
		contactsImage.setImageResource(R.drawable.contacts_unselected);
		contactsText.setTextColor(Color.parseColor("#82858b"));
		newsImage.setImageResource(R.drawable.news_unselected);
		newsText.setTextColor(Color.parseColor("#82858b"));
		settingImage.setImageResource(R.drawable.setting_unselected);
		settingText.setTextColor(Color.parseColor("#82858b"));
	}

	/**
	 * �N�Ҧ���Fragment���m�����ê��A�C
	 * 
	 * @param transaction
	 *            �Ω��Fragment����ާ@���ư�
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (contactsFragment != null) {
			transaction.hide(contactsFragment);
		}
		if (newsFragment != null) {
			transaction.hide(newsFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}
	}
}

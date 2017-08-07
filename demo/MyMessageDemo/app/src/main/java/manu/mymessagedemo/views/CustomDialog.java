package manu.mymessagedemo.views;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import manu.mymessagedemo.R;


public class CustomDialog extends Dialog {

	public CustomDialog(Context context, int theme) {
		super(context, theme);
	}

	public CustomDialog(Context context) {
		super(context);
	}

	public CustomDialog(Context context, int theme, int gravity) {
		super(context);
		getWindow().setGravity(gravity);
	}

	public static class Builder {

		private Context context;
		private String title;
		private String message;
		private String positiveButtonText;
		private String negativeButtonText;
		private View contentView;
		private boolean isCancel = true;
		private DialogInterface.OnClickListener positiveButtonClickListener,
				negativeButtonClickListener;

		public Builder(Context context) {
			this.context = context;
		}

		/**
		 * Set the Dialog message from String
		 *
		 * @return
		 */
		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}

		/**
		 * Set the Dialog message from resource
		 *
		 * @return
		 */
		public Builder setMessage(int message) {
			this.message = (String) context.getText(message);
			return this;
		}

		/**
		 * Set the Dialog title from resource
		 *
		 * @param title
		 * @return
		 */
		public Builder setTitle(int title) {
			this.title = (String) context.getText(title);
			return this;
		}

		/**
		 * Set the Dialog title from String
		 *
		 * @param title
		 * @return
		 */
		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setCancelable(boolean cancel) {
			this.isCancel = cancel;
			return this;
		}

		/**
		 * Set a custom content view for the Dialog. If a message is set, the
		 * contentView is not added to the Dialog...
		 *
		 * @param v
		 * @return
		 */
		public Builder setContentView(View v) {
			this.contentView = v;
			return this;
		}

		/**
		 * Set the positive button resource and it's listener
		 *
		 * @param positiveButtonText
		 * @param listener
		 * @return
		 */
		public Builder setPositiveButton(int positiveButtonText,
				DialogInterface.OnClickListener listener) {
			this.positiveButtonText = (String) context
					.getText(positiveButtonText);
			this.positiveButtonClickListener = listener;
			return this;
		}

		/**
		 * Set the positive button text and it's listener
		 *
		 * @param positiveButtonText
		 * @param listener
		 * @return
		 */
		public Builder setPositiveButton(String positiveButtonText,
				DialogInterface.OnClickListener listener) {
			this.positiveButtonText = positiveButtonText;
			this.positiveButtonClickListener = listener;
			return this;
		}

		/**
		 * Set the negative button resource and it's listener
		 *
		 * @param negativeButtonText
		 * @param listener
		 * @return
		 */
		public Builder setNegativeButton(int negativeButtonText,
				DialogInterface.OnClickListener listener) {
			this.negativeButtonText = (String) context
					.getText(negativeButtonText);
			this.negativeButtonClickListener = listener;
			return this;
		}

		/**
		 * Set the negative button text and it's listener
		 *
		 * @param negativeButtonText
		 * @param listener
		 * @return
		 */
		public Builder setNegativeButton(String negativeButtonText,
				DialogInterface.OnClickListener listener) {
			this.negativeButtonText = negativeButtonText;
			this.negativeButtonClickListener = listener;
			return this;
		}

		/**
		 * Create the custom dialog
		 */
		public CustomDialog create() {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// instantiate the dialog with the custom Theme
			final CustomDialog dialog = new CustomDialog(context,
					R.style.customDialog);
			View layout = inflater.inflate(R.layout.view_custom_dialog, null);
			dialog.addContentView(layout, new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// set the dialog title
			View topLayout =  layout
					.findViewById(R.id.c_top_line); 
			TextView titleTv = ((TextView) layout.findViewById(R.id.c_title));
			if (title != null) {
				titleTv.setVisibility(View.VISIBLE);
				titleTv.setText(title);
				topLayout.setVisibility(View.VISIBLE);
			} else {
				titleTv.setVisibility(View.GONE);
				topLayout.setVisibility(View.GONE);
			}

			// set the confirm button
			if (positiveButtonText != null) {
				TextView positiveTv=(TextView) layout.findViewById(R.id.positiveButton);
				positiveTv.setText(positiveButtonText);
				if (positiveButtonClickListener != null) {
					positiveTv.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									positiveButtonClickListener.onClick(dialog,
											DialogInterface.BUTTON_POSITIVE);
								}
							});
				}
				if(TextUtils.isEmpty(negativeButtonText)){
					positiveTv.setBackgroundResource(R.drawable.icon_single_btn);
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.positiveButton).setVisibility(
						View.GONE);
			}
			// set the cancel button
			if (negativeButtonText != null) {
				TextView negativeTv=(TextView) layout.findViewById(R.id.negativeButton);
				negativeTv.setText(negativeButtonText);
				if (negativeButtonClickListener != null) {
					negativeTv.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									negativeButtonClickListener.onClick(dialog,
											DialogInterface.BUTTON_NEGATIVE);
								}
							});
				}
				if(TextUtils.isEmpty(positiveButtonText)){
					negativeTv.setBackgroundResource(R.drawable.icon_single_btn);
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.negativeButton).setVisibility(
						View.GONE);
			}
			if(positiveButtonText==null && negativeButtonText==null){
				layout.findViewById(R.id.dialog_line).setVisibility(View.GONE);
			}
			if(TextUtils.isEmpty(positiveButtonText) || TextUtils.isEmpty(negativeButtonText)){
				layout.findViewById(R.id.verline).setVisibility(View.GONE);
			}
			// set the content message
			if (message != null) {
				((TextView) layout.findViewById(R.id.message)).setText(message);
			} else if (contentView != null) {
				((LinearLayout) layout.findViewById(R.id.content))
						.removeAllViews();
				((LinearLayout) layout.findViewById(R.id.content)).addView(
						contentView, new LayoutParams(
								LayoutParams.MATCH_PARENT,
								LayoutParams.WRAP_CONTENT));
			}
			dialog.setContentView(layout);
			DisplayMetrics metrics = new DisplayMetrics();
			((Activity) context).getWindow().getWindowManager()
					.getDefaultDisplay().getMetrics(metrics);
			int width = metrics.widthPixels;
			dialog.getWindow().setLayout(4 * width / 5,
					LayoutParams.WRAP_CONTENT);
			dialog.setCancelable(isCancel);
			return dialog;
		}
		/**
		 * Create the custom dialog
		 */
		public CustomDialog createAll(int w, int gravite) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// instantiate the dialog with the custom Theme
			final CustomDialog dialog = new CustomDialog(context,
					R.style.customDialog, gravite);
			View layout = inflater.inflate(R.layout.view_custom_dialog, null);
			dialog.addContentView(layout, new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// set the dialog title
			View topLayout = layout.findViewById(R.id.c_top_line);
			TextView titleTv = ((TextView) layout.findViewById(R.id.c_title));
			if (title != null) {
				titleTv.setVisibility(View.VISIBLE);
				titleTv.setText(title);
				topLayout.setVisibility(View.VISIBLE);
			} else {
				titleTv.setVisibility(View.GONE);
				topLayout.setVisibility(View.GONE);
			}

			// set the confirm button
			if (positiveButtonText != null) {
				((TextView) layout.findViewById(R.id.positiveButton))
						.setText(positiveButtonText);
				if (positiveButtonClickListener != null) {
					((TextView) layout.findViewById(R.id.positiveButton))
							.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									positiveButtonClickListener.onClick(dialog,
											DialogInterface.BUTTON_POSITIVE);
								}
							});
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.positiveButton).setVisibility(
						View.GONE);
			}
			// set the cancel button
			if (negativeButtonText != null) {
				((TextView) layout.findViewById(R.id.negativeButton))
						.setText(negativeButtonText);
				if (negativeButtonClickListener != null) {
					((TextView) layout.findViewById(R.id.negativeButton))
							.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									negativeButtonClickListener.onClick(dialog,
											DialogInterface.BUTTON_NEGATIVE);
								}
							});
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.negativeButton).setVisibility(
						View.GONE);
			}
			// set the content message
			if (message != null) {
				((TextView) layout.findViewById(R.id.message)).setText(message);
			} else if (contentView != null) {
				((LinearLayout) layout.findViewById(R.id.content))
						.removeAllViews();
				((LinearLayout) layout.findViewById(R.id.content)).addView(
						contentView, new LayoutParams(
								LayoutParams.MATCH_PARENT,
								LayoutParams.WRAP_CONTENT));
			}
			dialog.setContentView(layout);
			DisplayMetrics metrics = new DisplayMetrics();
			((Activity) context).getWindow().getWindowManager()
					.getDefaultDisplay().getMetrics(metrics);
			int width = metrics.widthPixels;
			dialog.getWindow().setLayout(width, LayoutParams.WRAP_CONTENT);
			dialog.setCancelable(isCancel);
			return dialog;
		}

	}

}

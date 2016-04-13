package com.vistrav.pop;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;

@SuppressWarnings("unused")
public class Pop {

    @StringRes
    private int yahButtonName;
    @StringRes
    private int nahButtonName;
    @StringRes
    private int aahButtonName;
    private Activity activity;
    private AlertDialog alertDialog;
    private Yah yah;
    private Nah nah;
    private Aah aah;
    private Pop.View popView;
    private AlertDialog.Builder builder;
    private android.view.View lView;

    protected Pop(Activity activity) {
        this.activity = activity;
        builder = new AlertDialog.Builder(activity);
    }

    public static Pop on(Activity activity) {
        return new Pop(activity);
    }

    public Pop with() {
        return this;
    }

    public Pop title(@StringRes int title) {
        builder.setTitle(title);
        return this;
    }

    public Pop title(@NonNull android.view.View view) {
        builder.setCustomTitle(view);
        return this;
    }

    public Pop icon(@NonNull Drawable icon) {
        builder.setIcon(icon);
        return this;
    }

    public Pop cancelable(boolean cancelable) {
        builder.setCancelable(cancelable);
        return this;
    }

    public Pop icon(@DrawableRes int icon) {
        builder.setIcon(icon);
        return this;
    }

    public Pop title(@NonNull String title) {
        builder.setTitle(title);
        return this;
    }

    public Pop body(@StringRes int body) {
        builder.setMessage(body);
        return this;
    }


    public Pop body(@NonNull String body) {
        builder.setMessage(body);
        return this;
    }

    public Pop layout(@LayoutRes int layout) {
        lView = activity.getLayoutInflater().inflate(layout, null);
        builder.setView(lView);
        return this;
    }

    private void createDialog() {
        if (yah != null) {
            int buttonId = yahButtonName != 0 ? yahButtonName : R.string.ok;
            builder.setPositiveButton(buttonId, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    yah.clicked(dialog, lView);
                }
            });
        }
        if (nah != null) {
            int buttonId = nahButtonName != 0 ? nahButtonName : R.string.cancel;
            builder.setNegativeButton(buttonId, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    nah.clicked(dialog, lView);
                }
            });
        }
        if (aah != null) {
            int buttonId = aahButtonName != 0 ? aahButtonName : R.string.neutral;
            builder.setNegativeButton(buttonId, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    aah.clicked(dialog, lView);
                }
            });
        }

        alertDialog = builder.create();
        alertDialog.show();
    }

    public AlertDialog show() {
        createDialog();
        return alertDialog;
    }

    public AlertDialog show(@NonNull Pop.View popView) {
        popView.prepare(lView);
        createDialog();
        return alertDialog;
    }

    public Pop when(@NonNull Yah yah) {
        this.yah = yah;
        return this;
    }

    public Pop when(@NonNull Aah aah) {
        this.aah = aah;
        return this;
    }

    public Pop when(@NonNull Nah nah) {
        this.nah = nah;
        return this;
    }

    public Pop when(@StringRes int yahButtonName, @NonNull Yah yah) {
        this.yah = yah;
        this.yahButtonName = yahButtonName;
        return this;
    }

    public Pop when(@StringRes int aahButtonName, @NonNull Aah aah) {
        this.aah = aah;
        this.aahButtonName = aahButtonName;
        return this;
    }

    public Pop when(@StringRes int nahButtonName, @NonNull Nah nah) {
        this.nah = nah;
        this.nahButtonName = nahButtonName;
        return this;
    }

    private interface Clickable {
        void clicked(DialogInterface dialog, @Nullable android.view.View view);
    }

    public interface Yah extends Clickable {
    }

    public interface Nah extends Clickable {
    }

    public interface Aah extends Clickable {
    }


    public interface View {
        void prepare(@Nullable android.view.View view);
    }

    public class NahImpl implements Nah {
        @Override
        public void clicked(DialogInterface dialog, @Nullable android.view.View view) {
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }
}

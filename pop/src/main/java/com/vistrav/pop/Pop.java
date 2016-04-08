package com.vistrav.pop;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

public class Pop {

    @StringRes
    private int title;
    @StringRes
    private int body;
    @LayoutRes
    private int layout;
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

    protected Pop(Activity activity) {
        this.activity = activity;
    }

    public static Pop on(Activity activity) {
        return new Pop(activity);
    }

    public Pop with() {
        return this;
    }

    public Pop title(@StringRes int title) {
        this.title = title;
        return this;
    }

    public Pop body(@StringRes int body) {
        this.body = body;
        return this;
    }

    public Pop layout(@LayoutRes int layout) {
        this.layout = layout;
        return this;
    }

    private void createDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (title != 0) {
            builder.setTitle(title);
        }
        final android.view.View view;
        if (body != 0) {
            builder.setMessage(body);
        }
        if (layout != 0) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(layout, null);
            builder.setView(view);
            if (popView != null) {
                popView.prepare(view);
            }
        } else {
            view = null;
        }
        if (yah != null) {
            int buttonId = yahButtonName != 0 ? yahButtonName : R.string.ok;
            builder.setPositiveButton(buttonId, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    yah.clicked(dialog, view);
                }
            });
        }
        if (nah != null) {
            int buttonId = nahButtonName != 0 ? nahButtonName : R.string.cancel;
            builder.setNegativeButton(buttonId, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    yah.clicked(dialog, view);
                }
            });
        }
        if (aah != null) {
            int buttonId = aahButtonName != 0 ? aahButtonName : R.string.neutral;
            builder.setNegativeButton(buttonId, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    aah.clicked(dialog, view);
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

    public AlertDialog show(Pop.View popView) {
        this.popView = popView;
        createDialog();
        return alertDialog;
    }

    public Pop when(Yah yah) {
        this.yah = yah;
        return this;
    }

    public Pop when(Aah aah) {
        this.aah = aah;
        return this;
    }

    public Pop when(Nah nah) {
        this.nah = nah != null ? nah : new NahImpl();
        return this;
    }

    public Pop when(int yahButtonName, Yah yah) {
        this.yah = yah;
        this.yahButtonName = yahButtonName;
        return this;
    }

    public Pop when(int aahButtonName, Aah aah) {
        this.aah = aah;
        this.aahButtonName = aahButtonName;
        return this;
    }

    public Pop when(int nahButtonName, Nah nah) {
        this.nah = nah;
        this.nahButtonName = nahButtonName;
        return this;
    }

    public interface Clickable {
        void clicked(DialogInterface dialog, android.view.View view);
    }

    public interface Yah extends Clickable {
    }

    public interface Nah extends Clickable {
    }

    public interface Aah extends Clickable {
    }


    public interface View {
        void prepare(android.view.View view);
    }

    public class NahImpl implements Nah {
        @Override
        public void clicked(DialogInterface dialog, android.view.View view) {
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }
}

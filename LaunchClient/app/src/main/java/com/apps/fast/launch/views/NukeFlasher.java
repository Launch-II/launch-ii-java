package com.apps.fast.launch.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;

import com.apps.fast.launch.R;
import com.apps.fast.launch.components.Utilities;

/**
 * Created by tobster on 03/05/16.
 */
public class NukeFlasher
{
    private static final int FLASH_OFF = 0;
    private static final int FLASH = 1;

    private boolean bFlash = false;
    private int lFlashState = FLASH_OFF;

    private View view;

    public NukeFlasher(View view)
    {
        this.view = view;
    }

    public void FlashUpdate(Context context)
    {
        if(bFlash)
        {
            view.setBackground(Utilities.DrawableFromAttr(context, R.attr.ButtonDrawableNormal));
        }
        else
        {
            switch (lFlashState)
            {
                case FLASH:
                {
                    view.setBackground(Utilities.DrawableFromAttr(context, R.attr.ButtonDrawableRed));
                }
                break;
            }
        }

        bFlash = !bFlash;
    }

    public void FlashOn()
    {
        lFlashState = FLASH;
    }
}

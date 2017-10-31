package com.byron.socketserver;

import android.app.Application;

import com.vilyever.logger.Logger;
import com.vilyever.logger.LoggerDisplay;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2017/10/27 1:10
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */

public class ServerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LoggerDisplay.initialize(this);
        LoggerDisplay.setDisplayLogTag(Logger.DefaultTag);
    }
}

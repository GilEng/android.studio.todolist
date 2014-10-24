package util;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by thiagoporto on 23/10/14.
 */
public class Mensagem {

    public static void Msg(Activity activity, String msg){
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }
}

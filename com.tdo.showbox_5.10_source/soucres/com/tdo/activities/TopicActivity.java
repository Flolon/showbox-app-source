package com.tdo.showbox.activities;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.models.topic.CurrentTopicScheme;
import com.tdo.showbox.models.topic.DelayedPush;
import com.tdo.showbox.models.topic.FbTopic;
import java.util.List;

public class TopicActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_topic);
        List execute = new Select().from(FbTopic.class).execute();
        String[] strArr = new String[execute.size()];
        for (int i = 0; i < execute.size(); i++) {
            strArr[i] = ((FbTopic) execute.get(i)).getName();
        }
        ListView listView = (ListView) findViewById(R.id.topic_listview);
        ListAdapter arrayAdapter = new ArrayAdapter(this, 17367048, strArr);
        arrayAdapter.setDropDownViewResource(R.layout.item_epizode_spinner);
        listView.setAdapter(arrayAdapter);
        TextView textView = (TextView) findViewById(R.id.txtv_times);
        CurrentTopicScheme currentTopicScheme = (CurrentTopicScheme) new Select().from(CurrentTopicScheme.class).executeSingle();
        if (currentTopicScheme != null) {
            textView.setText("1:" + currentTopicScheme.getDay1time() + "; 2:" + currentTopicScheme.getDay2time() + "; 3:" + currentTopicScheme.getDay3time() + "; 4:" + currentTopicScheme.getDay4time() + "; 5:" + currentTopicScheme.getDay5time() + "; 6:" + currentTopicScheme.getDay6time() + "; 7:" + currentTopicScheme.getDay7time());
        }
        final DelayedPush delayedPush = (DelayedPush) new Select().from(DelayedPush.class).executeSingle();
        View findViewById = findViewById(R.id.btn_push);
        if (delayedPush == null) {
            findViewById.setVisibility(4);
            return;
        }
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ TopicActivity f10790b;

            public void onClick(View view) {
                this.f10790b.m15186a(delayedPush);
            }
        });
    }

    /* renamed from: a */
    private void m15186a(DelayedPush delayedPush) {
        CharSequence charSequence = ("" + "FROM: " + delayedPush.getFrom() + ";\n") + "DATA: " + delayedPush.getData();
        Builder builder = new Builder(this);
        builder.setPositiveButton(R.string.ok, null);
        builder.setTitle(R.string.act_topic_push_details);
        builder.setMessage(charSequence);
        builder.show();
    }
}

package com.tdo.showbox.p117b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.p121g.C3216e;
import com.tdo.showbox.p129e.p130a.C3167a;
import java.util.List;

/* compiled from: ShowsLibFragment */
/* renamed from: com.tdo.showbox.b.l */
public class C2916l extends C2769a {
    /* renamed from: c */
    private ListView f11552c;
    /* renamed from: d */
    private List<TvItem> f11553d;
    /* renamed from: e */
    private C3216e f11554e;
    /* renamed from: f */
    private TextView f11555f;

    /* compiled from: ShowsLibFragment */
    /* renamed from: com.tdo.showbox.b.l$1 */
    class C29151 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ C2916l f11551a;

        C29151(C2916l c2916l) {
            this.f11551a = c2916l;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TvItem tvItem = (TvItem) new Select().from(TvItem.class).where("item_id=" + ((TvItem) this.f11551a.f11553d.get(i)).getItemId()).executeSingle();
            try {
                C3167a.m16903a().m16923c(tvItem.getLast_vieved_season() == 0 ? "-1" : "" + tvItem.getLast_vieved_season(), tvItem.getItemId());
            } catch (Exception e) {
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_lib_shows, null);
        this.f11555f = (TextView) this.a.findViewById(R.id.empty_txtv);
        this.f11552c = (ListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11552c.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11553d = new Select().from(TvItem.class).where("in_lib=1").execute();
        if (this.f11553d.size() == 0) {
            this.f11555f.setText(m15484h().getString(R.string.lib_shows_empty));
            this.f11555f.setVisibility(0);
        }
        this.f11554e = new C3216e(m15484h(), this.f11553d, !getActivity().getResources().getBoolean(R.bool.portrait_only));
        this.f11552c.setAdapter(this.f11554e);
        this.f11554e.notifyDataSetChanged();
        this.f11554e.m17004a(new C29151(this));
        return this.a;
    }
}

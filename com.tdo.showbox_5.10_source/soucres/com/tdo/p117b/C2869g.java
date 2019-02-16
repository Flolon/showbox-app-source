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
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.p121g.C3213d;
import com.tdo.showbox.p129e.p130a.C3167a;
import java.util.List;

/* compiled from: MovieLibFragment */
/* renamed from: com.tdo.showbox.b.g */
public class C2869g extends C2769a {
    /* renamed from: c */
    private ListView f11409c;
    /* renamed from: d */
    private List<MovieItem> f11410d;
    /* renamed from: e */
    private C3213d f11411e;
    /* renamed from: f */
    private TextView f11412f;

    /* compiled from: MovieLibFragment */
    /* renamed from: com.tdo.showbox.b.g$1 */
    class C28681 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ C2869g f11408a;

        C28681(C2869g c2869g) {
            this.f11408a = c2869g;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C3167a.m16903a().m16915a(((MovieItem) new Select().from(MovieItem.class).where("movie_id=" + ((MovieItem) this.f11408a.f11410d.get(i)).getMovieId()).executeSingle()).getMovieId(), true, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_lib_shows, null);
        this.f11412f = (TextView) this.a.findViewById(R.id.empty_txtv);
        this.f11409c = (ListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11409c.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11410d = new Select().from(MovieItem.class).where("in_lib=1").execute();
        if (this.f11410d.size() == 0) {
            this.f11412f.setText(m15484h().getString(R.string.lib_movies_empty));
            this.f11412f.setVisibility(0);
        }
        this.f11411e = new C3213d(m15484h(), this.f11410d, !getActivity().getResources().getBoolean(R.bool.portrait_only));
        this.f11409c.setAdapter(this.f11411e);
        this.f11411e.notifyDataSetChanged();
        this.f11411e.m17004a(new C28681(this));
        return this.a;
    }
}

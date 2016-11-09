#include <bits/stdc++.h>

using namespace std;

typedef long long LL;
typedef unsigned int UI;
typedef pair<int, int> pii;

const int MAXN = 500050;
const int MOD = 1000000007;

struct EndPoint {
	int x, idx;
	bool start;
	EndPoint(): x(0), idx(0), start(false) {}
	EndPoint(int x_, int idx_, bool start_): x(x_), idx(idx_), start(start_) {}
	bool operator<(const EndPoint& ep) const {
		if (x != ep.x) {
			return x < ep.x;
		}
		if (start != ep.start) {
			return start;
		}
		return idx < ep.idx;
	}
} endpoint[MAXN << 1];
int cover[MAXN];
vector<pii> intervals;
vector<pii> merged;

void clear() {
	memset(endpoint, 0, sizeof endpoint);
	memset(cover, 0, sizeof cover);
	intervals.clear();
	merged.clear();
}

int compute(LL A, LL x, LL B, LL y, LL C, LL M) {
	LL ret = A * x % M;
	ret = (ret + (B * y) % M) % M;
	return (ret + C) % M;
}

int main() {
    freopen("input", "r", stdin);
    freopen("output", "w", stdout);

    int testcase; cin >> testcase;
    for (int kase = 1; kase <= testcase; kase++) {
    	clear();

    	int N, L1, R1, A, B, C1, C2, M;
    	int index = 0;
    	cin >> N >> L1 >> R1 >> A >> B >> C1 >> C2 >> M;
    	intervals.push_back({L1, R1});
    	endpoint[index++] = EndPoint(L1, 0, true);
    	endpoint[index++] = EndPoint(R1 + 1, 0, false);
    	for (int i = 1, x = L1, y = R1; i < N; i++) {
    		int nx = compute(A, x, B, y, C1, M);
    		int ny = compute(A, y, B, x, C2, M);
    		int l = min(nx, ny);
    		int r = max(nx, ny);
    		intervals.push_back({l, r});
    		endpoint[index++] = EndPoint(l, i, true);
    		endpoint[index++] = EndPoint(r + 1, i, false);
    		x = nx;
    		y = ny;
    	}

    	sort(intervals.begin(), intervals.end());
    	int last = -1, area = 0;
    	for (int i = 0; i < N; i++) {
    		if (!merged.empty() && intervals[i].first <= merged.back().second) {
    			merged.back().second = max(intervals[i].second, merged.back().second);
    		} else {
    			merged.push_back(intervals[i]);
    		}
    		last = merged.back().second;
    	}
    	for (int i = 0; i < merged.size(); i++) {
    		area += merged[i].second - merged[i].first + 1;
    	}

    	sort(endpoint, endpoint + index);
    	set<int> s;
    	for (int i = 0, last = 0, lastx = -1, lastid = -1; i < index; i++) {
    		if (endpoint[i].start) {
    			s.insert(endpoint[i].idx);
    		} else {
    			s.erase(endpoint[i].idx);
    		}
    		if (last == 1) {
    			cover[lastid] += endpoint[i].x - lastx;
    		}
    		last = s.size();
    		lastx = endpoint[i].x;
    		lastid = *s.begin();
    	}

    	int maxv = 0;
    	for (int i = 0; i < N; i++) {
    		maxv = max(maxv, cover[i]);
    	}
    	cout << "Case #" << kase << ": " << area - maxv << endl;
    }
}

#include <bits/stdc++.h>

using namespace std;

typedef long long LL;
typedef unsigned int UI;
typedef pair<int, int> pii;

const int MAXN = 110;

LL factor[MAXN];
LL opt[MAXN][MAXN];

void clear() {
	memset(factor, 0, sizeof factor);
	memset(opt, 0, sizeof opt);
}

int main() {
    freopen("input", "r", stdin);
    freopen("output", "w", stdout);

    int testcase; cin >> testcase;
    for (int kase = 1; kase <= testcase; kase++) {
    	clear();
    	LL N, M; cin >> N >> M;

    	factor[0] = 1;
    	for (int i = 1; i <= N; i++) {
    		factor[i] = factor[i - 1] * i % M;
    	}
    	for (int i = 1; i <= N; i++) {
    		LL sum = 0;
    		for (int j = 1; j < i; j++) {
    			sum = (sum + opt[j][1] * factor[i - j] % M) % M;
    		}
    		opt[i][1] = (M + factor[i] - sum) % M;
    	}

    	for (int i = 1; i <= N; i++) {
    		for (int j = 2; j <= i; j++) {
    			LL sum = 0;
    			for (int k = 1; k < i; k++) {
    				sum = (sum + opt[k][1] * opt[i - k][j - 1] % M) % M;
    			}
    			opt[i][j] = sum;
    		}
    	}

    	LL ret = 0;
    	for (int i = 1; i <= N; i++) {
    		LL len = i * i % M;
    		ret = (ret + len * opt[N][i] % M) % M;
    	}
    	cout << "Case #" << kase << ": " << ret << endl;
    }
    return 0;
}

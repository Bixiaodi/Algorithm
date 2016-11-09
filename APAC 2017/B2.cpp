#include <bits/stdc++.h>

using namespace std;

typedef long long LL;
typedef unsigned int UI;
typedef pair<int, int> pii;

const int MAXK = 100010;
const int MOD = 1000000007;
LL BIT[MAXK];
LL AMod[MAXK], BMod[MAXK];
LL Cnt[MAXK];

void clear() {
    memset(BIT, 0, sizeof BIT);
    memset(AMod, 0, sizeof AMod);
    memset(BMod, 0, sizeof BMod);
    memset(Cnt, 0, sizeof Cnt);
}

void add(LL x, LL num) {
    while (x < MAXK) {
        BIT[x] = (BIT[x] + num) % MOD;
        x += x & -x;
    }
}

LL sum(LL x) {
    LL ret = 0;
    while (x) {
        ret = (ret + BIT[x]) % MOD;
        x -= x & -x;
    }
    return ret;
}

LL query(LL x) {
    return (MOD + sum(x + 1) - sum(x)) % MOD;
}

// x ^ A % K
LL power(LL x, LL A, LL K) {
    if (A == 0) {
        return 1 % K;
    }
    LL temp = power(x, A / 2, K);
    temp = (temp * temp) % K;
    if (A & 1) {
        temp = (temp * x) % K;
    }
    return temp;
}

int main() {
    freopen("input", "r", stdin);
    freopen("output", "w", stdout);

    int testcase; cin >> testcase;
    for (int kase = 1; kase <= testcase; kase++) {
        clear();
        LL A, B, K;
        LL N;
        cin >> A >> B >> N >> K;

        for (LL i = 1; i <= K; i++) {
            AMod[i] = power(i, A, K);
            BMod[i] = power(i, B, K);
        }

        for (LL i = 1; i <= K; i++) {
            Cnt[i] = (N / K) % MOD;
            if ((N % K) > i - 1) {
                Cnt[i] = (Cnt[i] + 1) % MOD;
            }
        }

        LL ret = 0;
        for (LL i = 1; i <= min(N, K); i++) {
            LL KA = AMod[i];
            LL KB = (K - KA) % K;
            ret = (ret + (Cnt[i] * query(KB) % MOD)) % MOD;
            if (KB == BMod[i]) { // if i == j
                LL temp = Cnt[i] * Cnt[i] % MOD;
                temp = (MOD + temp - Cnt[i]) % MOD;
                ret = (ret + temp) % MOD;
            }
            add(BMod[i] + 1, Cnt[i]);
        }
        memset(BIT, 0, sizeof BIT);
        for (LL i = min(N, K); i >= 1; i--) {
            LL KA = AMod[i];
            LL KB = (K - KA) % K;
            ret = (ret + (Cnt[i] * query(KB) % MOD)) % MOD;
            add(BMod[i] + 1, Cnt[i]);
        }
        cout << "Case #" << kase << ": " << ret << endl;
    }
}

//백준 10104번 // 갑자기 영어문제 나와서 당황 // 

#include<iostream>

using namespace std;


int main()
{
    int k;
    cin >> k;
    int frds[100];
    for (int i = 0; i < k; i++) {
        frds[i] = i + 1;
    }

    int m;
    cin >> m;

    int r[10];
    for (int i = 0; i < m; i++) 
    {
        cin >> r[i];
        int cnt = 0;

        for (int j = 0; j < k; j++) 
        {
            if (frds[j] != 0) 
            {
                cnt++;
                if (cnt == r[i]) 
                {
                    frds[j] = 0;
                    cnt = 0;
                }
            }
        }
    }

    for (int i = 0; i < k; i++) 
    {
        if (frds[i] != 0) 
        {
            cout << frds[i] << endl;
        }
    }

	return 0;

}

/* 취준하느라 많이 밀렸당... 
   날짜별로 하다보니 영어문제가 너무 많아서 못해먹겠음..
   단계별로 풀겠음.. */

// 백준 15552번
// 입출력 속도 빠르게 하기

#include <iostream>

using namespace std;


int main()
{
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int T;
    cin >> T;
    int A, B = 0;
    
    for (int i = 0; i < T; i++)
    {
        cin >> A;
        cin >> B;
        cout << A + B << '\n';
    }

    return 0;
}

// 백준 10103번 

#include<iostream>

using namespace std;


int main()
{
	int n;
	cin >> n;

	if (n > 15 || n < 1)
	{
		return 0;
	}

	int A, B;
	int A_scr = 100;
	int B_scr = 100;

	for (int i = 0; i < n; i++)
	{
		cin >> A;
		cin >> B;
		if (A > B)
		{
			B_scr = B_scr - A;
		}
		else if (A < B)
		{
			A_scr = A_scr - B;
		}
		else
		{
			continue;
		}
	}

	printf("%d\n%d\n", A_scr, B_scr);

	return 0;

}

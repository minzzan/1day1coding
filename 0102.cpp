//1월 2일 백준 10102

#include<iostream>

using namespace std;


int main()
{

	int V;
	cin >> V;
	
	int A_cnt = 0;
	int B_cnt = 0;
	char A[15];

	if (V < 1 || V>15)
	{
		return 0;
	}

	for (int i = 0; i < V; i++)
	{
		cin >> A[i];
		if (A[i] == 'A')
		{
			A_cnt++;
		}
		else
		{
			B_cnt++;
		}
	}

	if (A_cnt > B_cnt)
	{
		cout << 'A'<< endl;
	}
	if (B_cnt > A_cnt)
	{
		cout << 'B' << endl;
	}
	if(A_cnt==B_cnt)
	{
		cout << "Tie" << endl;
	}


	return 0;

}

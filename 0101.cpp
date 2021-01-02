// 1월 1일이라서 백준 10101  
#include<iostream>

using namespace std;


int main()
{

	int A; int B; int C;

	cin >> A;
	cin >> B;
	cin >> C;

	if (A == 0 || B == 0 || C == 0)
	{
		printf("Error");
		return 0;
	}

	if (A == 60 && B == 60 && C == 60)
	{
		printf("Equilateral");
		return 0;
	}
	if (A + B + C == 180)
	{
		if (A == B || B == C || A == C)
		{
			printf("Isosceles");
			return 0;
		}
		else
		{
			printf("Scalene");
			return 0;
		}
	}
	else if(A+B+C != 180)
	{
		printf("Error");
		return 0;
	}

	return 0;

}

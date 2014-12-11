#include <iostream>
#include <fstream>

using namespace std;

int x, y;

int gcf(int x, int y){
	if (y == 0)
		return x;
	else
		return gcf(y, (x%y));
}

int main(int argc, char *argv[]){


	//if ( ( argc != 1 ) && (argc != 3) )
	//	cout << "Usage: pairs <number> <number>\n";
	//else{
		//x = atoi(argv[1]);
		//y = atoi(argv[2]);
	cin >> x;
	cin >> y;
		int leGCF = gcf(x, y);
		int lcm = ( (x*y) / leGCF );

		cout << lcm << "\n" << lcm*2 << "\n" << lcm*3 << endl;
	//}

//	cout << "Press any key to continue..." << endl;
//	getchar();

	return 0;
}

/*/////////////////////////////////////////////////////////////////////////////
A store is bulk ordering cups and lids from different companies based on what
sales are going on. (And all word problems for programming competitions have
bizarre scenarios)

The cup manufacturer being used for this order only sells cups in multiples of 52, and
the lid manufacturer for this purchase only sells lids in multiples of 102.
What are the three smallest order of cups he will have to purchase if he
doesn't want to have any extra lids or cups?

Make sure that your program can be re-used every time he runs out of cups,
because he often switches companies.

Hint: the program should work if he expands his business (read: requires larger amounts of
cups)

--Sample Case 1--
INPUT:
52
102

OUTPUT:
2652
5304
7956

--Sample Case 2--
INPUT:
4
9

OUTPUT:
36
72
108
*//////////////////////////////////////////////////////////////////////////////

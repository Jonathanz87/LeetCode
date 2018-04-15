#include <iostream>
#include "DiceAndDanger.cpp"
using namespace std;

int main(){
    char c;
    DiceAndDanger builder;
    unsigned int attributeArray[6];
    do{
        builder.rollCharacter(attributeArray);
        builder.printCharacter(attributeArray);
        cout << "\nRoll another characer (y/n): ";
        cin >> c;
    }while(c == 'y');

}

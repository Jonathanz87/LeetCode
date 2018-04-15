#include "Dice.h"
#include <iostream>
#include <stdlib.h>
#include <chrono>

Dice::Dice(){
    Dice(6);
}

Dice::Dice(unsigned int side){
    if(side < 1){
        throw "Dice must have one or more side.";
    }
    this->side = side;
    this->values = new unsigned int[side];
    for(int i = 0; i < side; i++){
        this->values[i] = i + 1;
    }
    roll();
}

Dice::~Dice(){
    delete[] values;
}

void Dice::roll(){
    srand(std::chrono::time_point_cast<std::chrono::milliseconds>(std::chrono::system_clock::now()).time_since_epoch().count());

    for(int i = 0; i < side; i++){
        int j = rand() % side;
        if(i != j){
            this->values[i] = this->values[i] ^ this->values[j];
            this->values[j] = this->values[i] ^ this->values[j];
            this->values[i] = this->values[i] ^ this->values[j];
        }
    }
}

int Dice::read(){
    return read(1);
}

int Dice::read(unsigned int n){
    if(n <= 0 || n > this->side){
        throw printf("n must in range of [1, %d]", side);
    }

    return this->values[n - 1];
}

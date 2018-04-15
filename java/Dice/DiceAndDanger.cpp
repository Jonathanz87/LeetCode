#include "Dice.cpp"

class DiceAndDanger{
    private: const static int DICE_SIZE = 18;
    private: const static int ATTRIBUTE_SIZE = 6;
    private: Dice* dice;

    public: DiceAndDanger(){
        this->dice = new Dice(DICE_SIZE);
    }

    public: ~DiceAndDanger(){
        delete dice;
    }
    public: void rollCharacter(unsigned int* attributeArray){
        //array size check
        dice->roll();
        for(unsigned int i = 1; i <= ATTRIBUTE_SIZE; i++){
            *attributeArray++ = dice->read(i);
        }
    }

    public: void printCharacter(unsigned int* attributeArray){
        //array size check
        printf("Strength: %d\nConstitution: %d\nDexterity: %d\nIntelligence: %d\nWisdom: %d\nCharisma: %d\n",
            attributeArray[0],
            attributeArray[1],
            attributeArray[2],
            attributeArray[3],
            attributeArray[4],
            attributeArray[5]);
    }
    
};

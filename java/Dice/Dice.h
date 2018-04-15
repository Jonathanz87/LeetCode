class Dice{
    private: unsigned int side;
    private: unsigned int* values;

    public: Dice();

    public: Dice(unsigned int side);

    ~Dice();

    public: void roll();

    public: int read();

    public: int read(unsigned int n);

};

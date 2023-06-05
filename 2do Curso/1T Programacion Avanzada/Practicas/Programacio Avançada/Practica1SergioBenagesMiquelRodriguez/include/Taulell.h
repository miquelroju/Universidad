#ifndef TAULELL_H
#define TAULELL_H
#include <Bombeta.h>

class Taulell
{
    public:
        Taulell();
        virtual ~Taulell();
        void encendre(int quantes);
        void visualitzar();
        void premerBombeta(int f, int c);
        void apagar();
        int GetFiles();
        int GetColumnes();
        int GetEnceses();
        Bombeta GetBombeta(int a, int b);

    protected:

    private:
        static Bombeta contenidor[8][8];
        int files;
        int columnes;
        int enceses;

};

#endif // TAULELL_H

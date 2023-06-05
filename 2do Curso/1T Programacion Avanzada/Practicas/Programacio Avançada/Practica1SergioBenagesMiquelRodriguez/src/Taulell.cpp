#include "Taulell.h"
#include <stdlib.h>

Taulell::Taulell()
{
    files = 8;
    columnes = 8;
    for(int i=0; i<files; i++) {
        for(int j=0; j<columnes; j++) {
            contenidor[i][j] = Bombeta();
        }
    }
}

Taulell::~Taulell()
{

}

void Taulell::encendre(int quantes)
{
    for(int i=0; i<quantes; i++) {
        int m = rand() % 8 + 1;
        int n = rand() % 8 + 1;
        while(contenidor[m][n]==Bombeta.GetEnces) {
            int m = rand() % 8 + 1;
            int n = rand() % 8 + 1;
        }
        enceses++;
    }
}

void Taulell::visualitzar()
{
    for(int i=0; i<files; i++) {
        for(int j=0; j<columnes; j++) {
            visualitzar();
        }
    }
}

void Taulell::premerBombeta(int f, int c)
{
    // TODO
}

void Taulell::apagar()
{
    for(int i=0; i<files; i++) {
        for(int j=0; j<columnes; j++) {
            contenidor[i][j] == Bombeta();
        }
    }
}

int Taulell::GetFiles()
{
    return files;
}

int Taulell::GetColumnes()
{
    return columnes;
}

int Taulell::GetEnceses()
{
    return enceses;
}

Bombeta Taulell::GetBombeta(int a, int b)
{
    return contenidor[a][b];
}

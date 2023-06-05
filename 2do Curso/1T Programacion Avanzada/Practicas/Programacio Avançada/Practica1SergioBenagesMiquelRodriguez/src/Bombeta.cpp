#include "Bombeta.h"
#include <iostream>
using namespace std;

Bombeta::Bombeta()
{
    ences = false;
}

Bombeta::~Bombeta()
{
    //dtor
}


bool Bombeta::GetEnces()
{
    return ences;
}

void Bombeta::SetEnces(bool param)
{
    ences = param;
}

void Bombeta::Visualitza()
{
    if (ences == true) {
        cout<<"O";
    } else cout<<"-";
}

bool Bombeta::operator==(Bombeta b)
{
    if (ences == b.ences) {
        return true;
    } else return false;
}

bool Bombeta::operator!=(Bombeta b)
{
    if (ences != b.ences) {
        return true;
    } else return false;
}



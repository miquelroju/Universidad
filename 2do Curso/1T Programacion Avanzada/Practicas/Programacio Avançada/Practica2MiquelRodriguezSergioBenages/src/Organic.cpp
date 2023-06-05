#include "Organic.h"

Organic::Organic(string codi, string ubicacio, int anyColocacio, float tara) :
    ContenidorBrossa(string codi, ContenidorBrossa.MARRO,string ubicacio, int anyColocacio, float tara)
{
    //ctor
}

Organic::~Organic()
{
    //dtor
}

string Organic::getReciclat()
{
    return this->reciclat + " tones reciclades";
}

string Organic::toString() : ContenidorBrossa::toString()
{
    resultat += endl +"Pes: " + getReciclat();
}

string Organic::getType()
{
    return "Orgànic";
}

public void Organic::buidat(float pes)
{
    float resultat = pes-this->tara;
    resultat = resultat * 0.9;
    this->reciclat += resultat;
}

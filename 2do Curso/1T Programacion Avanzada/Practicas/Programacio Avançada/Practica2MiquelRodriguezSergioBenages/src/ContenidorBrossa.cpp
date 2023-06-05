#include "ContenidorBrossa.h"
#include <time.h>
#include <string.h>

ContenidorBrossa::ContenidorBrossa(string codi, int color, string ubicacio, int anyColocacio, float tara)
{
    this->codi = codi;
    if (color != ContenidorBrossa.GROC || color != ContenidorBrossa.MARRO || color != ContenidorBrossa.VERD || color != ContenidorBrossa.GRIS || color != ContenidorBrossa.BLAU)
    {
        throw new exception("Color erroni");
    } else this->color = color;
    this->ubicacio = ubicacio;
    if(anyColocacio < 1000 || anyColocacio > 2022) {
        throw new exception("Any erroni");
    } else this->anyColocacio = anyColocacio;
    this->anyRetirada = 0;
    this->tara = tara;
}

ContenidorBrossa::ContenidorBrossa(string codi, int color, int anyColocacio, float tara)
{
    this(codi, color, NULL, anyColocacio, tara);
}

string ContenidorBrossa::getTipusBrossa()
{
    switch(color)
    {
        case ContenidorBrossa.GROC:
            return "Contenidor plàstic";
            break;
        case ContenidorBrossa.MARRO:
            return "Contenidor orgànic";
            break;
        case ContenidorBrossa.VERD:
            return "Contenidor vidre";
            break;
        case ContenidorBrossa.GRIS:
            return "Contenidor rebuig";
            break;
        case ContenidorBrossa.BLAU:
            return "Contenidor paper";
            break;
    }
}

void ContenidorBrossa::retirarViaPublica()
{
    time_t now;
    struct tm *now_tm;
    now = time(NULL);
    now_tm = localtime(&now);
    int year = now_tm->tm_year + 1900;

    this->anyRetirada = year;
    if (this->ubicacio == NULL)
    {
        throw new exception("El contenidor no està ubicat a la via pública");
    } else this->ubicacio = NULL;
    this->anyColocacio = 0;
}

string ContenidorBrossa::getUbicacio()
{
    if (this->ubicacio == NULL)
    {
        throw new exception("El contenidor està al magatzem");S
    } else return this->ubicacio;
}

void ContenidorBrossa::setUbicacio(string ubicacio)
{
    if (this->ubicacio == NULL)
    {
        retirarViaPublica();
    } else this->ubicacio = ubicacio;
}

int ContenidorBrossa::getCodi()
{
    return this->codi;
}

string ContenidorBrossa::getEstat()
{
    time_t now;
    struct tm *now_tm;
    now = time(NULL);
    now_tm = localtime(&now);
    int year = now_tm->tm_year + 1900;
    int any = year - this->anyColocacio

    if (any > 5)
    {
        return "C   ontenidor vell";
    } else if (any <= 5 && any >= 3)
    {
        return "Contenidor seminou";
    } else if (any < 3)
    {
        return "Contenidor nou";
    } else if (this->anyColocacio == 0)
    {
        return "Contenidor retirat";
    }
}

bool ContenidorBrossa::operator==(ContenidorBrossa *p)
{
    if(this->getCodi() == *p->getCodi()) return true;
    else return false;
}

bool ContenidorBrossa::operator<(ContenidorBrossa *p)
{
    if(this->getCodi < *p->getCodi()) return true;
    else return false;
}

bool ContenidorBrossa::operator>(ContenidorBrossa *p)
{
    return !this->operator<(*p);
}

void toString()
{
    String resultat = "";
    resultat = "Codi: " + this->getCodi() + endl + "Color: " + this->getTipusBrossa() + endl + "Ubicació: ";
    if (this->getUbicacio() == 0)
    {
        resultat += ;
    } else resultat += this->getUbicacio();
    resultat += endl + "Tara: " + this->tara;
}

/*
void buidat (float pes)
{
    // NO ENTENC AQUEST METODE
    this->tara-=pes;
}

string getType()
{
    return this->getTipusBrossa();
}
*/

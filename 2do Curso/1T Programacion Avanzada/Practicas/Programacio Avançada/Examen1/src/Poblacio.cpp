#include "Poblacio.h"

Poblacio::Poblacio()
{

}

Poblacio::~Poblacio()
{
    while (ubicacions->seg != nullptr)
    {
        delete ubicacions->inf;
        ubicacions->seg = ubicacions->seg->seg;
    }
    delete ubicacions;
    for (int i = 0; i < contenidors.length; i++)
    {
        for (int j = 0; j < contenidors[i].length; j++)
        {
            delete contenidors[i][j];
        }
    }
    delete contenidors;
}

Poblacio::operator==(Poblacio *p)
{
    int cmp = ubicacions->quants.compareTo(*p->ubicacions->quants);

    if (cmp == 0) return true;
    else return false;

}

Poblacio::operator!=(Poblacio *p)
{
    return !(operator==(*p));
}

Poblacio::sonIguals(Poblacio p1, Poblacio p2, Poblacio p3)
{
    if (p1->operator==(p2) && p1->operator==(p3) && p2->operator==(p3)) return true;
    else return false;
}

Poblacio::sonIguals(Poblacio* p1, Poblacio* p2, Poblacio* p3)
{
    if (*p1->operator==(*p2) && *p1->operator==(*p3) && *p2->operator==(*p3)) return true;
    else return false;
}

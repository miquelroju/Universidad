#ifndef ORGANIC_H
#define ORGANIC_H


class Organic : public ContenidorBrossa
{
    public:
        Organic(string codi, string ubicacio, int anyColocacio, float tara);
        virtual ~Organic();
        string getReciclat();
        string toString();
        string getType();
        public void buidat(float pes):

    protected:

    private:
        float reciclat;
};

#endif // ORGANIC_H

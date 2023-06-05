#ifndef CONTENIDORBROSSA_H
#define CONTENIDORBROSSA_H


class ContenidorBrossa
{
    public:
        const int GROC = 0;
        const int MARRO = 1;
        const int VERD = 2;
        const int GRIS = 3;
        const int BLAU = 4;

        public ContenidorBrossa(string codi, int color, string ubicacio, int anyColocacio, float tara);
        public ContenidorBrossa(string codi, int color, int anyColocacio, float tara);
        string getTipusBrossa();
        void retirarViaPublica();
        string getUbicacio();
        void setUbicacio(string ubicacio);
        int getCodi();
        string getEstat();
        bool operator==(ContenidorBrossa *p);
        bool operator<(ContenidorBrossa *p);
        bool operator>(ContenidorBrossa *p);
        void toString();
        virtual void buidat (float pes) = 0;
        virtual string getType() = 0;
        virtual string getReciclat() = 0;
        ~ContenidorBrossa();

    protected:
        float tara;

    private:
        string codi;
        int color;
        string ubicacio;
        int anyColocacio;
        int anyRetirada;

};

#endif // CONTENIDORBROSSA_H

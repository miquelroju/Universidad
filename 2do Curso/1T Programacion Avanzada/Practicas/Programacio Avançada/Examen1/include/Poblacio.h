#ifndef POBLACIO_H
#define POBLACIO_H


class Poblacio
{
    public:
        Poblacio();
        Ubicacio MesContenidors();
        void afegirContenidor(ContenidorBrossa *);
        void eliminarContenidor(ContenidorBrossa *);
        ContenidorBrossa mesReciclatOrganic(int *) throw exception;
        String toString();
        String menorCodi(int *);
        bool operator==(Poblacio *);
        bool operator!=(Poblacio *);
        bool sonIguals(Poblacio p1, Poblacio p2, Poblacio p3);
        bool sonIguals(Poblacio* p1, Poblacio* p2, Poblacio* p3);
        virtual ~Poblacio();

    private:
        struct NodeU
        {
            private Ubicacio inf;
            private int quants;
            private NodeU seg;
            public NodeU(Ubicacio on, NodeU seg) {
                this.inf = on;
                this.quants = 0;
                this.seg = seg;
            }
        };

        NodeU ubicacions;
        static AcbEnll contenidors[6][3];
};

#endif // POBLACIO_H

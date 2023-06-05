#ifndef BOMBETA_H
#define BOMBETA_H


class Bombeta
{
    public:
        Bombeta();
        virtual ~Bombeta();
        bool GetEnces();
        void SetEnces(bool param);
        void Visualitza();
        bool operator==(Bombeta);
        bool operator!=(Bombeta);

    protected:

    private:
        bool ences;
};

#endif // BOMBETA_H

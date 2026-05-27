# Cronograma do Projeto (Gráfico de Gantt)

Representação visual do cronograma de desenvolvimento da plataforma de incidentes baseada na modelagem de casos de uso estabelecida.

```mermaid
gantt
    title Cronograma de Desenvolvimento - Sistema de Incidentes
    dateFormat  YYYY-MM-DD
    axisFormat  %d/%m
    
    section Iniciacao e Requisitos
    Planejamento e Alinhamento (1.1 a 1.3)     :active, p1, 2026-05-26, 3d
    Modelagem Fina de Casos de Uso (2.1 e 2.2) : r1, after p1, 3d
    Modelo de Classes Conceitual (2.3)         : r2, after r1, 2d
    
    section Arquitetura e Seguranca
    Definicao de Controle de Acesso RBAC (3.2) : a1, after r2, 2d
    Prototipagem de Telas de Triagem (3.3)     : a2, after r1, 4d
    
    section Desenvolvimento Funcional
    Setup DB e Backend Estavel (4.1)           : c1, after a1, 2d
    Dev Registro e Consultas (UC001 UC007 UC008) :crit, c2, after c1 a2, 5d
    Dev Evidencias e Acoes (UC002 UC005)       :crit, c3, after c2, 4d
    Dev Relatorios e Filtros (UC004)           : c4, after c2, 3d
    Dev Avaliacao e Parecer (UC003 UC006)      :crit, c5, after c3, 4d
    
    section Testes e Validacao
    Testes de Sigilo de Dados e Acessos        : t1, after c5, 3d
    Homologacao de Fluxos Operacionais         :crit, t2, after t1 c4, 3d
    
    section Encerramento
    Compilacao do PDF Final do Projeto         : i1, after t2, 2d

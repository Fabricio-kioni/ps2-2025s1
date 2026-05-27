
### 3. Arquivo Atualizado: `riscos.md`
```markdown
# Matriz de Riscos do Projeto

Mapeamento de riscos com base nas restrições de arquitetura, governança corporativa e sustentabilidade operacional do sistema de incidentes.

| ID | Descrição do Risco | Probabilidade | Impacto | Severidade | Ação Mitigatória (Prevenção) | Plano de Contingência (Reação) |
| :---: | :--- | :---: | :---: | :---: | :--- | :--- |
| **R01** | **Introdução de Stack Heterogêneo:** Uso de linguagens/frameworks fora do padrão da TI da empresa, inflando custos futuros de suporte. | Média | Alto | **Alta** | Validar as escolhas tecnológicas na fase de planejamento, restringindo o desenvolvimento estritamente às tecnologias dominadas pelo time. | Substituição imediata de componentes fora do padrão por bibliotecas nativas ou homologadas no ecossistema da empresa. |
| **R02** | **Quebra do Sigilo Absoluto:** Acesso indevido de funcionários comuns a detalhes de vulnerabilidades críticas ou dados de clientes/empregados. | Baixa | Muito Alto | **Alta** | Aplicar criptografia e máscaras de dados em banco; implementar rigorosamente a barreira de privilégios RBAC desenvolvida na fase 3. | Revogação imediata de credenciais comprometidas, isolamento da trilha de logs de auditoria e acionamento do protocolo interno de vazamento. |
| **R03** | **Violação de Fronteira Sistêmica:** Tentativas de expandir o escopo para que o sistema execute remediações automáticas de infraestrutura (ex: bloquear IPs). | Média | Médio | **Média** | Manter o foco do desenvolvimento estritamente em governança, documentação e registro auditável, blindando o escopo nas reuniões semanais. | Isolar os módulos afetados e documentar que integrações ativas dependem de uma futura e nova fase de arquitetura. |
| **R04** | **Rejeição por Atrito Político:** Uso do sistema como ferramenta de punição interdepartamental ao invés de registro auditável de conformidade. | Baixa | Alto | **Média** | Garantir que o sistema registre apenas fatos técnicos e logs impessoais, assegurando o equilíbrio de poder desenhado no fluxo do Comitê. | Revisão das mensagens de sistema, relatórios e rótulos para neutralizar termos interpretativos, focando apenas em dados técnicos de segurança. |
| **R05** | **Envio de Incidentes Incompletos:** Sobrecarga do Comitê de Segurança com relatórios sem evidências ou sem histórico de ações tomadas. | Alta | Médio | **Média** | Implementar travas de sistema em nível de código no UC006, impedindo o clique no botão de envio caso UC002 ou UC005 não estejam preenchidos. | Interface retorna o incidente automaticamente para o status "Aberto" apontando as pendências operacionais que o analista deve corrigir. |

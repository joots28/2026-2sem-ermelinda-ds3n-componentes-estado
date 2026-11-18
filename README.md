# Componentes e Estado

Atividade prática de Desenvolvimento de Sistemas — 2º semestre de 2026.

Aplicativo Android desenvolvido em **Kotlin** com **Jetpack Compose** para demonstrar a criação de componentes de interface e o gerenciamento de estado.

## Funcionalidades demonstradas

- **Contador:** adicionar, diminuir e zerar um valor.
- **Campo de texto:** atualizar uma saudação enquanto o usuário digita.
- **Switch:** ativar e desativar notificações.
- **Checkbox:** alternar o status de uma tarefa.
- **Restaurar valores:** retornar todos os componentes ao estado inicial.

## Conceitos utilizados

### Componentes

Cada parte da interface foi separada em funções anotadas com `@Composable`, como `CounterCard`, `NameCard`, `NotificationsCard` e `TaskCard`. Isso facilita a organização e a reutilização da interface.

### Estado

O estado é declarado no componente principal com `rememberSaveable`:

```kotlin
var counter by rememberSaveable { mutableIntStateOf(0) }
```

Quando o valor muda, o Jetpack Compose recompõe os componentes que utilizam esse estado e atualiza a interface.

### Elevação de estado (State Hoisting)

Os componentes filhos recebem os valores por parâmetros e comunicam alterações por funções de callback. Dessa forma, o estado permanece centralizado na tela principal, enquanto os componentes filhos ficam responsáveis pela apresentação e interação.

## Tecnologias

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- Gradle

## Como executar

1. Clone este repositório.
2. Abra a pasta do projeto no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Execute o aplicativo em um emulador ou dispositivo Android com versão 7.0 (API 24) ou superior.

## Estrutura principal

```text
app/
└── src/main/
    ├── java/com/example/a20262semermelindads3ncomponentesestado/
    │   └── MainActivity.kt
    └── res/
        └── values/
            └── strings.xml
```

## Identificação

- **Aluno:** Jonathan Otiniel
- **Turma:** 3º DS
- **Disciplina/atividade:** Componentes e Estado
- **Semestre:** 2º semestre de 2026

> Observação: esta implementação utiliza o projeto-base Android que já estava neste repositório e apresenta exemplos didáticos de componentes e estado em Jetpack Compose. Caso o professor tenha fornecido um roteiro ou requisitos específicos diferentes, eles devem ser conferidos antes da entrega.

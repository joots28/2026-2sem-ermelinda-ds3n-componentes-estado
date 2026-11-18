package com.example.a20262semermelindads3ncomponentesestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a20262semermelindads3ncomponentesestado.ui.theme._20262semErmelindaDs3nComponentesEstadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            _20262semErmelindaDs3nComponentesEstadoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComponentsStateScreen()
                }
            }
        }
    }
}

/**
 * Tela principal da atividade.
 *
 * O estado fica concentrado neste componente e é compartilhado com os
 * componentes filhos por meio de parâmetros e funções de callback.
 * Essa técnica é conhecida como elevação de estado (state hoisting).
 */
@Composable
fun ComponentsStateScreen() {
    var counter by rememberSaveable { mutableIntStateOf(0) }
    var name by rememberSaveable { mutableStateOf("") }
    var notificationsEnabled by rememberSaveable { mutableStateOf(true) }
    var taskCompleted by rememberSaveable { mutableStateOf(false) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Componentes e Estado",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Atividade prática com Kotlin e Jetpack Compose",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            ExplanationCard()

            CounterCard(
                value = counter,
                onDecrease = { if (counter > 0) counter-- },
                onIncrease = { counter++ },
                onReset = { counter = 0 }
            )

            NameCard(
                name = name,
                onNameChange = { name = it }
            )

            NotificationsCard(
                enabled = notificationsEnabled,
                onEnabledChange = { notificationsEnabled = it }
            )

            TaskCard(
                completed = taskCompleted,
                onCompletedChange = { taskCompleted = it }
            )

            Button(
                onClick = {
                    counter = 0
                    name = ""
                    notificationsEnabled = true
                    taskCompleted = false
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Restaurar valores iniciais")
            }

            Text(
                text = "Os valores são mantidos durante a recriação da tela graças ao rememberSaveable.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun ExplanationCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "O que esta atividade demonstra?",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Cada bloco da tela é um componente reutilizável. " +
                    "Os valores mudam conforme a interação do usuário, e o Compose " +
                    "atualiza automaticamente os elementos que dependem desses valores."
            )
        }
    }
}

@Composable
private fun CounterCard(
    value: Int,
    onDecrease: () -> Unit,
    onIncrease: () -> Unit,
    onReset: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "1. Contador",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = value.toString(),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = onDecrease,
                    enabled = value > 0,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Diminuir")
                }

                Button(
                    onClick = onIncrease,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Adicionar")
                }
            }

            OutlinedButton(
                onClick = onReset,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Zerar contador")
            }
        }
    }
}

@Composable
private fun NameCard(
    name: String,
    onNameChange: (String) -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "2. Campo de texto",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            OutlinedTextField(
                value = name,
                onValueChange = onNameChange,
                label = { Text("Digite seu nome") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = if (name.isBlank()) {
                    "A saudação aparecerá quando você digitar seu nome."
                } else {
                    "Olá, $name! O texto é atualizado em tempo real."
                },
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun NotificationsCard(
    enabled: Boolean,
    onEnabledChange: (Boolean) -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "3. Notificações",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (enabled) "Notificações ativadas" else "Notificações desativadas",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Switch(
                checked = enabled,
                onCheckedChange = onEnabledChange
            )
        }
    }
}

@Composable
private fun TaskCard(
    completed: Boolean,
    onCompletedChange: (Boolean) -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = completed,
                onCheckedChange = onCompletedChange
            )

            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = "4. Tarefa concluída",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = if (completed) "Status: concluída" else "Status: pendente",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ComponentsStateScreenPreview() {
    _20262semErmelindaDs3nComponentesEstadoTheme {
        ComponentsStateScreen()
    }
}

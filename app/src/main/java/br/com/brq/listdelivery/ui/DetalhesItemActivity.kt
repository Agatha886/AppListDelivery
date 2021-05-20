package br.com.brq.listdelivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.brq.listdelivery.R
import br.com.brq.listdelivery.model.AdapterRecyclerView
import br.com.brq.listdelivery.model.StatusTarefa
import br.com.brq.listdelivery.model.dataClasse.Tarefas
import br.com.brq.listdelivery.model.dataClasse.Tarefas.Companion.listaTarefas

class DetalhesItemActivity : AppCompatActivity() {

    var btnEntregue: View? = null
    var btnAtrasado:   View? = null
    var btnCancelado: View? = null
    var btnPendente: View? = null
    var adapter: AdapterRecyclerView? = null

    lateinit var imgTarefa : ImageView
    lateinit var tituloView: TextView
    lateinit var dateView: TextView
    lateinit var statusView: TextView
    lateinit var nomeDestinatarioView: TextView
    lateinit var cpfView: TextView
    lateinit var enderecoView: TextView
    lateinit var descView: TextView
    lateinit var obsView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_item)

        carregarElementos()

        var index: Int = intent.extras?.get("index") as Int

        var produto = intent.extras?.get("nomeProduto")
        tituloView.text = "Produto: ${produto.toString()}"

        var data = intent.extras?.get("data")
        dateView.text = "Data: ${data.toString()}"

        var status = intent.extras?.get("status")
        statusView.text = "Status: ${status.toString()}"

        var pessoa = intent.extras?.get("destinatario")
        nomeDestinatarioView.text = "Destinatario: ${pessoa.toString()}"

        var cpf = intent.extras?.get("cpfDestinatario")
        cpfView.text = "CPF: ${cpf.toString()}"

        var endereco = intent.extras?.get("endereco")
        enderecoView.text = "Endereço: ${endereco.toString()}"

        var descricao = intent.extras?.get("descProduto")
        descView.text = "Descrição: ${descricao.toString()}"

        var photoTarefa = intent.extras?.get("img")
        imgTarefa.setImageResource(photoTarefa as Int)

        var obs = intent.extras?.get("obs")
        obsView.text = "Observação: ${obs.toString()}"
        println(obs.toString())

        carregarEventos(index)

    }

    fun carregarElementos() {
        btnEntregue = findViewById(R.id.buttonEntregue)
        btnAtrasado = findViewById(R.id.buttonAtrasado)
        btnPendente = findViewById(R.id.buttonPendente)
        btnCancelado = findViewById(R.id.buttonCancelado)

        imgTarefa= findViewById(R.id.imageTarefaItem)
        tituloView = findViewById(R.id.tituloView)
        dateView = findViewById(R.id.dateView)
        statusView = findViewById(R.id.statusView)
        nomeDestinatarioView = findViewById(R.id.nomeDestinatarioView)
        cpfView = findViewById(R.id.cpfView)
        enderecoView = findViewById(R.id.enderecoView)
        descView = findViewById(R.id.descView)
        obsView = findViewById(R.id.obsView)

    }

    fun carregarEventos(index: Int) {

        btnEntregue?.setOnClickListener {
            statusView.text = "Status: ENTREGUE"
            imgTarefa.setImageResource(R.drawable.tarefa_entregue)

            for (tarefas in Tarefas.BancoDelistasTarefas) {
                if (listaTarefas[index] == tarefas) {
                    tarefas.status = StatusTarefa.ENTREGUE
                    tarefas.photo = R.drawable.tarefa_entregue
                }
            }
        }

            btnPendente?.setOnClickListener {
                statusView.text = "Status: PENDENTE"
                imgTarefa.setImageResource(R.drawable.tarefa_pendente)

                for (tarefas in Tarefas.BancoDelistasTarefas) {
                    if (listaTarefas[index] == tarefas) {
                        tarefas.status = StatusTarefa.PENDENTE
                        tarefas.photo = R.drawable.tarefa_pendente
                    }
                }

            }

            btnCancelado?.setOnClickListener {
                statusView.text = "Status: CANCELADO"
                imgTarefa.setImageResource(R.drawable.tarefa_cancelada)

                for (tarefas in Tarefas.BancoDelistasTarefas) {
                    if (listaTarefas[index] == tarefas) {
                        tarefas.status = StatusTarefa.CANCELADO
                        tarefas.photo = R.drawable.tarefa_cancelada
                    }
                }
            }

            btnAtrasado?.setOnClickListener {
                statusView.text = "Status: ATRASADO"
                imgTarefa.setImageResource(R.drawable.tarefa_atrasada)

                for (tarefas in Tarefas.BancoDelistasTarefas) {
                    if (listaTarefas[index] == tarefas) {
                        tarefas.status = StatusTarefa.ATRASADO
                        tarefas.photo = R.drawable.tarefa_atrasada
                    }
                }

            }

    }
}



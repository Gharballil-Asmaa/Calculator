package com.lauren.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lauren.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClear.setOnClickListener {
            binding.tvInput.text = ""
            binding.tvOutput.text = ""
        }
        binding.btnBracketRight.setOnClickListener {
            binding.tvInput.append(")")
        }
        binding.btnBracketLeft.setOnClickListener {
            binding.tvInput.append("(")

        }
        binding.btnSum.setOnClickListener {
            binding.tvInput.append("+")
        }
        binding.btnSub.setOnClickListener {
            binding.tvInput.append("-")
        }
        binding.btnMultiply.setOnClickListener {
            binding.tvInput.append("*")
        }
        binding.btnDivision.setOnClickListener {
            binding.tvInput.append("/")
        }
        binding.btnResult.setOnClickListener {
            showResult()
        }
        binding.btnDot.setOnClickListener {
            binding.tvInput.append(".")
        }
        binding.btnBackspace.setOnClickListener {
            val length = binding.tvInput.length()
            if (length > 0)
                binding.tvInput.text = binding.tvInput.text.subSequence(0, length -1)
        }
        binding.btnOne.setOnClickListener {
            binding.tvInput.append("1")
        }
        binding.btnTwo.setOnClickListener {
            binding.tvInput.append("2")
        }
        binding.btnThree.setOnClickListener {
            binding.tvInput.append("3")
        }
        binding.btnFour.setOnClickListener {
            binding.tvInput.append("4")
        }
        binding.btnFive.setOnClickListener {
            binding.tvInput.append("5")
        }
        binding.btnSix.setOnClickListener {
            binding.tvInput.append("6")
        }
        binding.btnSeven.setOnClickListener {
            binding.tvInput.append("7")
        }
        binding.btnEight.setOnClickListener {
            binding.tvInput.append("8")
        }
        binding.btnNine.setOnClickListener {
            binding.tvInput.append("9")
        }
        binding.btnZero.setOnClickListener {
            binding.tvInput.append("0")
        }

    }

    private fun showResult() {
       try {
           val expression = binding.tvInput.text.toString()
           val result = ExpressionBuilder(expression).build()
           val value = result.evaluate()

           binding.tvOutput.text = DecimalFormat("0.##").format(value).toString()
       }catch (e : Exception){
           binding.tvOutput.text = "Error"
       }
    }
}
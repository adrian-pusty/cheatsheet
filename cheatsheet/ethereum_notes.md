# Ethereum Cheatsheet

# 1. Cryptography
## Private Key → Public Key → Address
### Public Key
**K = k * G**  
where:  
**K** - Public key defined as the point: **K = (x, y)**  
**k** - Private key (random 256-bit number)  
**G** - Constant point (generator point - part of the secp256k1 standard)  
<b>*</b> - elliptic curve "multiplication" operator  

Serialization format:  
**04 + x-coordinate** (32 bytes/64 hex) + **y-coordinate** (32 bytes/64 hex)  
where:  
**04** - Means it's an uncompressed point with 65 bytes length (counting prefix itself)

### Elliptic Curve
**secp256k1 elliptic curve** ( see: [bitcoin-core
secp256k1]( https://github.com/bitcoin-core/secp256k1) )  
y<sup>2</sup> = (x<sup>3</sup> + 7) over (F<sub>p</sub>)  
or:  
y<sup>2</sup> mod p = (x<sup>3</sup> + 7) mod p  
where:  
**p** = 2<sup>256</sup> - 2<sup>32</sup> - 2<sup>9</sup> - 2<sup>8</sup> - 2<sup>7</sup> - 2<sup>6</sup> - 2<sup>4</sup> - 1  
[Python example ("Mastering Ethereum")](https://github.com/ethereumbook/ethereumbook/blob/develop/04keys-addresses.asciidoc#using-python-to-confirm-that-this-point-is-on-the-elliptic-curve)  

### Ethereum Address
Last 160 bits (20 least significant bytes)(optionally prefixed with <i>0x</i>) of:  
**Keccak256(K)**  
where:  
**K** - Public key (without <i>04</i> prefix)

Using **helpeth** command-line tool to generate: Address, ICAP Address and Public Key from Private Key:  
npm install -g helpeth   
helpeth keyDetails -p {address prefixed with 0x}

## Hex Encoding with Checksum in Capitalization
<i>Protecting the integrity of the address against typing or reading mistakes</i> (see: [validation](https://github.com/ethereumbook/ethereumbook/blob/develop/04keys-addresses.asciidoc#detecting-an-error-in-an-eip-55-encoded-address))
    Capitalize each alphabetic address<sup>[1]</sup> character if the corresponding hex digit of the hash<sup>[2]</sup>  is **greater than or equal to 0x8**.<br/>
  [1] - Lowercase address, without the 0x prefix
  [2] - First 20 bytes of Keccak256 hash of the lowercase hexadecimal address

# 2. Wallets
## Mnemonic Code Words (BIP-39)
Generating mnemonic words (and then seed)
1. **S** = Cryptographically random sequence of 128 to 256 bits.
2. **checksum** = n-first bits of the: SHA-256( S ), 
   where:   
   • n = length_of_S / 32
3. **sequence_and_checksum** = concatenation( S, checksum )
4. Divide sequence_and_checksum into sections of 11 bits
5. **mnemonic_code** = sequence of words: each 11-bit value mapped to a word (one of 2048 words //**todo** link))
6. **seed** (512-bit) = PBKDF2( concatenation( mnemonic_code, **salt** )), where:  
   • PBKDF2 – key-stretching function  
   • salt – concatenation(  “mnemonic”, (optional)passphrase )  


[ConsenSys/eth-lightwallet
   ](https://github.com/ConsenSys/eth-lightwallet) - A minimal ethereum javascript wallet. [...]  It uses BIP32 and BIP39 to generate an HD tree of addresses from a randomly generated 12-word seed.

## HD wallet tree structure  

m / purpose' / coin_type' / account' / change / address_index  
where:  
coin_type - type of cryptocurrency coin (see: [SLIP0044](https://github.com/satoshilabs/slips/blob/master/slip-0044.md))

-------------------------------------------------
# Useful links
- [The Ethereum Improvement Proposal repository (GitHub)](https://github.com/ethereum/EIPs)

- [**Docs Solidity**](https://docs.soliditylang.org/en/latest/) 
- [GitHub Solidity](https://github.com/ethereum/solidity)

- [Remix - Ethereum IDE](https://remix.ethereum.org/)
  
- [A minimal ethereum javascript wallet (BIP-32-compatible)](https://github.com/ConsenSys/eth-lightwallet )
  
- [Ropsten Ethereum Faucet (testnet)](https://faucet.ropsten.be/)
    
- [Mastering Ethereum book (GitHub)](https://github.com/ethereumbook/ethereumbook)
  
- [ETH Gas Station | Consumer oriented metrics for the Ethereum gas market](https://www.ethgasstation.info)

- [The ERC20 standard](http://bit.ly/2CUf7WG)
--------------------
~ https://github.com/ethereumbook/ethereumbook/